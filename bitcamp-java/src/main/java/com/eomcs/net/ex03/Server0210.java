// 클라이언트와 입출력 테스트 - character stream
package com.eomcs.net.ex03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server0210 {
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("클라이언트의 연결을 기다리고 있음.");

      try (Socket socket = serverSocket.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        System.out.println("대기열에서 클라이언트 정보를 꺼내 소켓을 생성하였음.");

        String str = in.readLine();
        System.out.println(str);

        System.out.print(">");
        keyboard.nextLine();

        out.println(str);
        // out.flush();
        // character stream의 경우, 출력 데이터를 내부 버퍼에 보관하고 있다가
        // flush()가 호출되면 출력을 수행한다.
        // 단, close()를 호출하면, close() 내부에서 flush()를 수행
        System.out.println("클라이언트에게 데이터를 보냈음.");
        System.out.print(">");
        keyboard.nextLine();

      }
      System.out.println("클라이언트와의 연결을 끊었음.");
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 종료!");
  }

}

