// LMS 서버
package com.eomcs.lms;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.util.RequestHandler;
import com.eomcs.util.RequestMappingHandlerMapping;

public class ServerApp {

  static Logger logger = LogManager.getLogger(ServerApp.class);
  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();
  ExecutorService executorService = Executors.newCachedThreadPool();
  boolean serverStop = false;
  ApplicationContext iocContainer;
  RequestMappingHandlerMapping handlerMapper;

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }

  public void service() {

    notifyApplicationInitialized();
    iocContainer = (ApplicationContext) context.get("iocContainer");
    handlerMapper = (RequestMappingHandlerMapping) context.get("handlerMapper");

    try (ServerSocket serverSocket = new ServerSocket(9999)) {

      ServerApp.logger.info("클라이언트 연결 대기중...");

      while (true) {
        Socket socket = serverSocket.accept();
        ServerApp.logger.info("클라이언트와 연결되었음!");

        executorService.submit(() -> {
          processRequest(socket);
          ServerApp.logger.info("--------------------------------------");
        });

        if (serverStop) {
          break;
        }

      }

    } catch (Exception e) {
      ServerApp.logger.error(String.format("서버 준비 중 오류 발생!: %s", e.getMessage()));
    }

    executorService.shutdown();

    while (true) {
      if (executorService.isTerminated()) {
        break;
      }
      try {
        Thread.sleep(500);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    notifyApplicationDestroyed();

    ServerApp.logger.info("서버 종료!");
  }


  void processRequest(Socket clientSocket) {

    try (Socket socket = clientSocket;
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      String[] requestLine = in.nextLine().split(" ");
      // 기타 나머지 요청 데이터 버리기

      while (true) {
        String line = in.nextLine();
        if (line.length() == 0) {
          break;
        }
      }

      String method = requestLine[0];
      String requestUri = requestLine[1];
      ServerApp.logger.info(String.format("method => %s", method));
      ServerApp.logger.info(String.format("request-uri => %s", requestUri));

      // HTTP 응답 헤더 출력
      printResponseHeader(out);

      if (requestUri.equalsIgnoreCase("/server/stop")) {
        quit(out);
        return;
      }

      RequestHandler requestHandler = handlerMapper.getHandler(requestUri);

      if (requestHandler != null) {
        try {
          // servlet.service(in, out);
          requestHandler.getMethod().invoke(requestHandler.getBean(), in, out);
        } catch (Exception e) {
          out.println("요청 처리 중 오류 발생!");
          out.println(e.getMessage());

          ServerApp.logger.info("클라이언트 요청 처리 중 오류 발생:");
          ServerApp.logger.info(e.getMessage());
          StringWriter strWriter = new StringWriter();
          e.printStackTrace(new PrintWriter(strWriter));
          ServerApp.logger.debug(strWriter.toString());
        }
      } else {
        notFound(out);
        ServerApp.logger.info("해당 명령을 지원하지 않습니다.");
      }
      out.println("!end!");
      out.flush();
      ServerApp.logger.info("클라이언트에게 응답하였음!");

    } catch (Exception e) {
      ServerApp.logger.error(String.format("예외 발생: %s", e.getMessage()));
      StringWriter strWriter = new StringWriter();
      e.printStackTrace(new PrintWriter(strWriter));
      ServerApp.logger.debug(strWriter.toString());
    }
  }

  private void notFound(PrintStream out) throws IOException {
    out.println("요청한 명령을 처리할 수 없습니다.");
  }

  private void quit(PrintStream out) throws IOException {
    serverStop = true;
    out.println("OK");
    out.println("!end!");
    out.flush();
  }

  private void printResponseHeader(PrintStream out) {
    out.println("HTTP/1.1 200OK");
    out.println("Server: Apache");
    out.println();
  }

  public static void main(String[] args) {
    ServerApp.logger.info("서버 수업 관리 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new ContextLoaderListener());
    app.service();
  }
}
