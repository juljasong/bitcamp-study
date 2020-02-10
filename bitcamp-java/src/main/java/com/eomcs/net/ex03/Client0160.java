// 서버와 입출력 테스트 - byte stream + buffer
package com.eomcs.net.ex03;

import java.io.BufferedOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import com.eomcs.io.ex08.BufferedInputStream;

public class Client0160 {
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
        Scanner in = new Scanner(new BufferedInputStream(socket.getInputStream()))) {

      System.out.println("서버와 연결되었음!");

      out.println("ABC가각간");
      out.flush();
      System.out.println("서버에 데이터를 보냈음!");

      String str = in.nextLine();
      System.out.println(str);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


