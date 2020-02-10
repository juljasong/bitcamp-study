// 서버와 입출력 테스트 - byte stream : Data 주고 받기
package com.eomcs.net.ex03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0130 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    try (Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었음!");

      System.out.print(">");
      keyboard.nextLine();

      out.writeInt(1567891234);
      // out.flush();
      // byte stream을 사용할 땐 flush() 안써도 됨
      System.out.println("서버에 데이터 보냈음!");

      int value = in.readInt();
      System.out.println(value);

    } catch (Exception e) {
      e.printStackTrace();
    }
    keyboard.close();
  }
}


