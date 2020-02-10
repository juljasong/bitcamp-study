// stateful 방식의 이점 활용 - 계산기 서버 만들기 II
package com.eomcs.net.ex04.stateful2;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    ServerSocket ss = new ServerSocket(8888);

    // 연결되어있는 동안 클라이언트의 작업 결과 유지 가능
    while (true) {
      Socket socket = ss.accept();
      try {
        processRequest(socket);
      } catch (Exception e) {
        System.out.println("클라이언트 요청 처리 중 오류 발생!");
        System.out.println("다음 클라이언트의 요청을 처리합니다.");
      }
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


