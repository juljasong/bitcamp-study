// Apache HttpClient 라이브러리를 이용하여 웹서버 만들기 II
package com.eomcs.httpcomponents.server;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.MethodNotSupportedException;
import org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.http.ExceptionLogger;

public class Exam0210 {

  public static void main(String[] args) throws Exception {
    SocketConfig socketConfig =
        SocketConfig.custom().setSoTimeout(15000).setTcpNoDelay(true).build();

    final HttpServer server = ServerBootstrap.bootstrap().setListenerPort(8888)
        .setServerInfo("Bitcamp/1.1").setSocketConfig(socketConfig).setSslContext(null)
        .setExceptionLogger(new StdErrorExceptionLogger())
        .registerHandler("*", new MyHttpRequestHandler()).create();

    server.start();
    System.out.println("서버 실행 중...");

    server.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        server.shutdown(5, TimeUnit.SECONDS);
      }
    });
  }

  static class StdErrorExceptionLogger implements ExceptionLogger {

    @Override
    public void log(final Exception ex) {
      if (ex instanceof SocketTimeoutException) {
        System.err.println("Connection timed out");
      } else if (ex instanceof ConnectionClosedException) {
        System.err.println(ex.getMessage());
      } else {
        ex.printStackTrace();
      }
    }

  }

  static class MyHttpRequestHandler implements HttpRequestHandler {

    public void handle(final HttpRequest request, final HttpResponse response,
        final HttpContext context) throws HttpException, IOException {

      // 클라이언트가 요청한 방식을 알아 낸다.
      String method = request.getRequestLine().getMethod().toUpperCase(Locale.ROOT);
      if (!method.equals("GET")) { // GET 요청이 아니라면 오류 내용을 응답한다.
        throw new MethodNotSupportedException(method + " method not supported");
      }

      response.setStatusCode(HttpStatus.SC_OK);
      StringEntity entity = new StringEntity("<html><body><h1>Hello!</h1></body></html>",
          ContentType.create("text/html", "UTF-8"));
      response.setEntity(entity);
    }
  }
}
