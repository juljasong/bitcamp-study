// Apache HttpClient 라이브러리를 이용하여 웹서버 만들기
package com.eomcs.httpcomponents.server;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.EndpointDetails;
import org.apache.hc.core5.http.ExceptionListener;
import org.apache.hc.core5.http.HttpConnection;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.MethodNotSupportedException;
import org.apache.hc.core5.http.impl.bootstrap.HttpServer;
import org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.io.SocketConfig;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.FileEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpCoreContext;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.TimeValue;

public class Exam0110 {

  public static void main(final String[] args) throws Exception {

    // Document root directory
    // => HTML, CSS, JS, GIF, JPEG 등 정적 자원(실행X 읽어서 리턴)이 있는 폴더
    // <-> 동적자원: 서블릿/JSP 같이 서버에서 실행하는 자원
    final String docRoot = "./webroot";
    SSLContext sslContext = null;

    final SocketConfig socketConfig = SocketConfig.custom()//
        .setSoTimeout(15, TimeUnit.SECONDS)//
        .setTcpNoDelay(true)//
        .build();//

    final HttpServer server = ServerBootstrap.bootstrap()//
        .setListenerPort(9999)// 웹서버 포트 번호 설정
        .setSocketConfig(socketConfig)// 기본 소켓 동작 설정
        .setSslContext(null)// SSL 설정
        .setExceptionListener(new MyExceptionListener())// 예외 처리자 설정
        .register("*", new HttpFileHandler()) // 요청 처리자 설정
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

  static class HttpFileHandler implements HttpRequestHandler {

    private final String docRoot = "./webroot";

    @Override
    public void handle(final ClassicHttpRequest request, // 클라이언트 요청 정보
        final ClassicHttpResponse response, // 클라이언트 응답처리 도구
        final HttpContext context // HTTP 설정 도구
    ) throws HttpException, IOException {

      final String method = request.getMethod();
      if (!Method.GET.isSame(method) && !Method.HEAD.isSame(method)
          && !Method.POST.isSame(method)) {
        throw new MethodNotSupportedException(method + " method not supported");
      }

      // 클라이언트가 요청한 자원 경로
      // => HTTP 요청 URL: http://localhost:9999/board/list
      // => 자원경로 : /board/list
      final String path = request.getPath();

      final HttpEntity incomingEntity = request.getEntity();
      if (incomingEntity != null) {
        final byte[] entityContent = EntityUtils.toByteArray(incomingEntity);
        System.out.println("Incoming incomingEntity content (bytes): " + entityContent.length);
      }

      // 클라이언트가 요청한 자원의 경로 준비
      // =>./webroot + /index.html
      // => ./webroot/index.html
      final File file = new File(this.docRoot, URLDecoder.decode(path, "UTF-8"));
      if (!file.exists()) {
        // 클라이언트가 요청한 자원(파일)이 없다면 오류 메시지를 보낸다.
        response.setCode(HttpStatus.SC_NOT_FOUND);
        final String msg = "File " + file.getPath() + " not found";
        final StringEntity outgoingEntity =
            new StringEntity("<html><body><h1>" + msg + "</h1></body></html>",
                ContentType.create("text/html", "UTF-8"));
        response.setEntity(outgoingEntity);
        System.out.println(msg);

      } else if (!file.canRead() || file.isDirectory()) {
        // 클라이언트가 요청한 자원(파일)이 디렉토리이거나
        // 읽을 수 없다면 오류 메시지를 보낸다.
        response.setCode(HttpStatus.SC_FORBIDDEN);
        final String msg = "Cannot read file " + file.getPath();
        final StringEntity outgoingEntity =
            new StringEntity("<html><body><h1>" + msg + "</h1></body></html>",
                ContentType.create("text/html", "UTF-8"));
        response.setEntity(outgoingEntity);
        System.out.println(msg);

      } else {
        // 클라이언트가 요청한 자원(파일)을 읽어서 보낸다.
        final HttpCoreContext coreContext = HttpCoreContext.adapt(context);
        final EndpointDetails endpoint = coreContext.getEndpointDetails();
        response.setCode(HttpStatus.SC_OK);
        String contentType = null;
        if (path.equals("/favicon.ico")) {
          contentType = "image/x-icon";
        } else {
          contentType = "text/html";
        }
        final FileEntity body =
            new FileEntity(file, ContentType.create(contentType, (Charset) null));
        response.setEntity(body);
        System.out.println(endpoint + ": serving file " + file.getPath());
      }
    }

  }

}
