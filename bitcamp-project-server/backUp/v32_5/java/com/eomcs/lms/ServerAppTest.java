package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class ServerAppTest {

  public static void main(String[] args) {
    String serverAddr = null;
    int port = 0;
    Scanner sc = new Scanner(System.in);

    try {
      System.out.print("서버? ");
      serverAddr = sc.nextLine();
      System.out.print("포트? ");
      port = Integer.parseInt(sc.nextLine());
    } catch (Exception e) {
      System.out.println("서버 주소 혹은 포트 번호가 유효하지 않습니다.");
      sc.close();
      return;
    }

    try (Socket socket = new Socket(serverAddr, port); // 서버 연결
        // 소켓을 통해 데이터 읽고 쓰는 도구 준비
        PrintStream out = new PrintStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {
      System.out.println("서버와 연결되었습니다.");
      System.out.print("메시지: ");
      String sendMsg = sc.nextLine();
      // 서버에 메시지 전송
      // => 서버로부터 메시지를 받을 때 까지 리턴X : Blocking 방식 동작
      out.println(sendMsg);
      System.out.println("서버에 메시지를 전송하였습니다.");

      // 서버에서 메시지 수신 및 출력
      String message = in.readUTF();
      System.out.println("서버에서 응답 결과를 수신하였습니다.");
      System.out.println("서버: " + message);

      if (message.equals("OK")) {
        List<Board> list = (List<Board>) in.readObject();
        for (Board b : list) {
          System.out.println(b);
        }

      }
      System.out.println("서버와 연결을 끊었습니다.");
    } catch (Exception e) {
      System.out.print("예외발생: ");
      e.printStackTrace();
    }
    sc.close();
  }
}
