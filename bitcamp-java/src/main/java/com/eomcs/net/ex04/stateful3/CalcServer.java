// stateful 방식의 이점 활용 - 계산기 서버 만들기 II
package com.eomcs.net.ex04.stateful3;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class CalcServer {

  // 클라이언트 통신 부분 별도 분리하여 독립적 실행

  static class RequestHandler extends Thread {

    Socket socket;

    public RequestHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      // JVM과 분리하여 별도로 실행될 코드를 이 메서드에 둔다
      try {
        processRequest(socket);
      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
      } finally {
        System.out.println("클라이언트 연결 종료!");
      }
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket ss = new ServerSocket(8888);

    // 연결되어있는 동안 클라이언트의 작업 결과 유지 가능
    while (true) {
      Socket socket = ss.accept();
      InetSocketAddress remoteAddr = (InetSocketAddress) socket.getRemoteSocketAddress();

      System.out.println(socket.getRemoteSocketAddress() instanceof SocketAddress);
      System.out.println(socket.getRemoteSocketAddress() instanceof InetSocketAddress);
      System.out.printf("클라이언트(%s:%d)가 연결되었습니다.\n", remoteAddr.getAddress(), remoteAddr.getPort());

      // 연결된 클라이언트가 연결을 끊기 전까지 대기 중인 다른 클라이언트 요청을 처리할 수 없다
      // => 스레드 사용 전 문제점
      // => 사용 후 : 클라이언트와 대화하는 부분을 스레드로 분리하여 실행
      RequestHandler requestHandler = new RequestHandler(socket);
      requestHandler.start(); // 스레드 실행 -> start() 내부에서 run() 호출
      // start() 호출한 후에 즉시 리턴
      System.out.printf("%s 클라이언트와의 대화를 별도의 스레드에서 담당합니다. \n", remoteAddr.getAddress());
    }
    // ss.close();
  }

  static void processRequest(Socket socket) throws Exception {
    try (Socket socket2 = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream());) {

      int result = 0; // 계산 결과 유지할 변수

      loop: while (true) {
        String op = in.readUTF();
        int a = in.readInt();

        switch (op) {
          case "+":
            result += a;
            break;
          case "-":
            result -= a;
            break;
          case "*":
            result *= a;
            break;
          case "/":
            result /= a;
            break;
          case "quit":
            break loop;
        }

        out.printf("계산결과: %d\n", result);
      }
      out.println("quit");
    }
  }
}


