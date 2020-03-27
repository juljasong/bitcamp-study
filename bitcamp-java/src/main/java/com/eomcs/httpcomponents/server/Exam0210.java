// Apache HttpClient 라이브러리를 이용하여 웹서버 만들기 II
package com.eomcs.httpcomponents.server;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.EndpointDetails;
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
import org.apache.hc.core5.http.protocol.HttpCoreContext;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.TimeValue;

public class Exam0210 {

  public static void main(String[] args) throws Exception {

    // Document root directory
    // => HTML, CSS, JS, GIF, JPEG 등 정적 자원(실행X 읽어서 리턴)이 있는 폴더
    // <-> 동적자원: 서블릿/JSP 같이 서버에서 실행하는 자원

    final SocketConfig socketConfig = SocketConfig.custom()//
        .setSoTimeout(15, TimeUnit.SECONDS)//
        .setTcpNoDelay(true)//
        .build();//

    final HttpServer server = ServerBootstrap.bootstrap()//
        .setListenerPort(9999)// 웹서버 포트 번호 설정
        .setSocketConfig(socketConfig)// 기본 소켓 동작 설정
        .setSslContext(null)// SSL 설정
        .setExceptionListener(new MyExceptionListener())// 예외 처리자 설정
        .register("*", new MyRequestHandler()) // 요청 처리자 설정
        .create();// 웹서버 객체 생성
    server.start();
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        server.close(CloseMode.GRACEFUL);
      }
    });

    System.out.println("✅ Listening on port " + 9999);

    server.awaitTermination(TimeValue.MAX_VALUE);

  }


  static class MyExceptionListener implements ExceptionListener {
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
  }


  static class MyRequestHandler implements HttpRequestHandler {

    private final String docRoot = "./webroot";

    @Override
    public void handle(final ClassicHttpRequest request, // 클라이언트 요청 정보
        final ClassicHttpResponse response, // 클라이언트 응답처리 도구
        final HttpContext context // HTTP 설정 도구
    ) throws HttpException, IOException {
      // 클라이언트가 요청한 자원(파일) 열어서 보냄
      final HttpCoreContext coreContext = HttpCoreContext.adapt(context);
      final EndpointDetails endpoint = coreContext.getEndpointDetails();
      response.setCode(HttpStatus.SC_OK);
      final StringEntity body = new StringEntity("<html><body><h1>안녕하세요!</h1></body></html>",
          ContentType.create("text/html", Charset.forName("UTF-8")));
      response.setEntity(body);

    }

  }
}
