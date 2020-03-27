// LMS 서버
package com.eomcs.lms;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ExceptionListener;
import org.apache.hc.core5.http.HttpConnection;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.impl.bootstrap.HttpServer;
import org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.TimeValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.util.RequestHandler;
import com.eomcs.util.RequestMappingHandlerMapping;

public class ServerApp implements ExceptionListener, HttpRequestHandler {

  static Logger logger = LogManager.getLogger(ServerApp.class);
  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();
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

  public void service() throws Exception {

    notifyApplicationInitialized();
    iocContainer = (ApplicationContext) context.get("iocContainer");
    handlerMapper = (RequestMappingHandlerMapping) context.get("handlerMapper");

    // 소켓 설정
    SocketConfig socketConfig = SocketConfig.custom()//
        .setSoTimeout(15, TimeUnit.SECONDS)//
        .setTcpNoDelay(true)//
        .build();//
    // HTTP 서버 준비
    HttpServer server = ServerBootstrap.bootstrap()//
        .setListenerPort(9999)// 웹서버 포트 번호 설정
        .setSocketConfig(socketConfig)// 기본 소켓 동작 설정
        .setSslContext(null)// SSL 설정
        .setExceptionListener(this)// 예외 처리자 설정
        .register("*", this) // 요청 처리자 설정
        .create();// 웹서버 객체 생성

    server.start();
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        notifyApplicationDestroyed();
        ServerApp.logger.info("서버 종료!");
        server.close(CloseMode.GRACEFUL);
      }
    });

    ServerApp.logger.info("✅ Listening on port " + 9999);
    server.awaitTermination(TimeValue.MAX_VALUE);
  }

  private void notFound(PrintWriter out) throws IOException {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>실행 오류</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>실행 오류</h1>");
    out.println("<p>요청한 명령을 처리할 수 없습니다.</p>");
  }

  private void error(PrintWriter out, Exception e) throws IOException {
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>실행 오류</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>실행 오류</h1>");
    out.println("<p>요청한 명령을 처리할 수 없습니다.</p>");
  }

  private String getServletPath(String requestUri) {
    // requestUri => /member/add?email=aaa@test.com&name=1111&password=1234
    return requestUri.split("\\?")[0]; // ex) /member/add
  }

  private Map<String, String> getParameters(String requestUri) throws Exception {
    String[] items = requestUri.split("\\?");
    // 데이터(Query String) 따로 저장
    // => email=aaa@test.com&name=aaa&password=1111
    Map<String, String> params = new HashMap<>();
    if (items.length > 1) {
      ServerApp.logger.debug(String.format("query string => %s", items[1])); // info:시스템 운영자
                                                                             // debug:개발자
      String[] entries = items[1].split("&");
      for (String entry : entries) {
        ServerApp.logger.debug(String.format("parameter => %s", entry));
        String[] kv = entry.split("=");
        // 웹브라우저가 URL 인코딩하여 보낸 데이터 디코딩 필요
        if (kv.length > 1) {
          String value = URLDecoder.decode(kv[1], "UTF-8");
          params.put(kv[0], value);
        } else {
          params.put(kv[0], "");
        }
      }
    }
    return params;
  }

  // ExceptionListener interface 구현
  @Override
  public void onError(final Exception ex) {
    ex.printStackTrace();
  }

  @Override
  public void onError(final HttpConnection conn, final Exception ex) {
    if (ex instanceof SocketTimeoutException) {
      System.err.println("Connection timed out");
    } else if (ex instanceof ConnectionClosedException) {
      System.err.println(ex.getMessage());
    } else {
      ex.printStackTrace();
    }
  }
  // ExceptionListener interface 구현 끝

  public static void main(String[] args) throws Exception {
    ServerApp.logger.info("서버 수업 관리 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new ContextLoaderListener());
    app.service();
  }

  public void handle(ClassicHttpRequest request, ClassicHttpResponse response, HttpContext context)
      throws HttpException, IOException {
    ServerApp.logger.info("--------------------------------------");
    ServerApp.logger.info("클라이언트의 요청이 들어옴!");

    StringWriter outBuffer = new StringWriter(); // 클라이언트로 콘텐츠 출력 시 사용할 도구
    PrintWriter out = new PrintWriter(outBuffer);

    String method = request.getMethod(); // GET|POST|PUT|HEAD|PUT|...
    String requestUri = request.getPath(); // /photoboard/list?lessonNo=100
    ServerApp.logger.info("{} {}", method, requestUri);

    try {
      String servletPath = getServletPath(requestUri);
      ServerApp.logger.debug(String.format("resource url => %s", servletPath));

      Map<String, String> params = getParameters(requestUri);
      RequestHandler requestHandler = handlerMapper.getHandler(servletPath);
      if (requestHandler != null) {
        try {
          // request handler 메서드 호출
          requestHandler.getMethod().invoke(requestHandler.getBean(), params, out);
        } catch (Exception e) {
        }
      } else {
        notFound(new PrintWriter(out));
        ServerApp.logger.info("해당 명령을 지원하지 않습니다.");
      }
      out.flush();
      ServerApp.logger.info("클라이언트에게 응답하였음!");
    } catch (Exception e) {
      error(new PrintWriter(out), e);

      ServerApp.logger.info("클라이언트 요청 처리 중 오류 발생:");
      ServerApp.logger.info(e.getMessage());
      StringWriter strWriter = new StringWriter();
      e.printStackTrace(new PrintWriter(strWriter));
      ServerApp.logger.debug(strWriter.toString());
    }

    response.setCode(HttpStatus.SC_OK);

    response.setEntity(new StringEntity(outBuffer.toString(),
        ContentType.create("text/html", Charset.forName("UTF-8"))));
  }
}
