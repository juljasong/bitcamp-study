// 서버와 입출력 테스트 - character stream
package com.eomcs.net.ex03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client0210 {
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      System.out.println("서버와 연결되었음!");
      out.println("ABC가각간");
      // out.flush();
      // character stream의 경우, 출력 데이터를 내부 버퍼에 보관하고 있다가
      // flush()가 호출되면 출력을 수행한다.
      System.out.println("서버에 데이터를 보냈음!");

      String str = in.readLine();
      System.out.println(str);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


