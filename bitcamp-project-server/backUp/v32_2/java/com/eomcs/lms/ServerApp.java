/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.eomcs.lms;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {
  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템입니다.");

    try (// 서버쪽 연결 준비 : 9999 포트에서 클라이언트 연결 기다림
        ServerSocket serverSocket = new ServerSocket(9999)) {
      System.out.println("클라이언트 연결 대기중...");
      while (true) {
        // 대기하고 있는 클라이언트와 연결
        // 대기하고 있는 클라이언트와 연결될 떄 까지 리턴 X
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트와 연결되었습니다.");
        // 클라이언트 요청 처리
        processRequest(socket);
        System.out.println("-----------------------------");
      }
    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생");
      return;
    }
  }

  static void processRequest(Socket clientSocket) {
    try (
        // 요청 처리 끝난 후 클라이언트와 연결된 소켓 자동으로 닫으려면
        // 별도의 로컬 변수에 담는다
        Socket socket = clientSocket;
        // 클라이언트 메시지 수신 후 클라이언트 전송할 입출력 도구 준비
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {
      System.out.println("통신을 위한 입출력 스트림을 준비하였습니다. ");

      // 클라이언트가 보낸 메시지 수신
      // 한 줄의 메시지를 읽을 떄까지 리턴하지 않는다.
      String message = in.nextLine();
      System.out.println("클라이언트가 보낸 메시지를 수신하였습니다.");
      System.out.println("클라이언트 : " + message);

      // 클라이언트에게 메시지를 전송 => 클라이언트가 메시지를 모두 읽을 때 까지 리턴하지 않는다.
      out.println("hi(julia)");
      System.out.println("클라이언트로 메시지를 전송하였습니다.");

    } catch (Exception e) {
      System.out.print("예외발생: ");
      e.printStackTrace();
    }

  }
}
