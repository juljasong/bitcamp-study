// 서버와 입출력 테스트 - byte stream : Data 주고 받기 II
package com.eomcs.net.ex03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0140 {
  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    try (Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었음!");

      System.out.print(">");
      keyboard.nextLine();

      out.writeInt(1567891234);
      out.writeByte(100);
      out.writeFloat(3.14f);
      out.writeUTF("가각간");
      // out.flush();
      // byte stream을 사용할 땐 flush() 안써도 됨
      System.out.println("서버에 데이터 보냈음!");

      int value = in.readInt();
      byte value2 = in.readByte();
      float value3 = in.readFloat();
      String value4 = in.readUTF();
      System.out.printf("%d, %d, %f, %s\n", value, value2, value3, value4);

    } catch (Exception e) {
      e.printStackTrace();
    }
    keyboard.close();
  }
}


