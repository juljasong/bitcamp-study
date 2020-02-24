// LMS 클라이언트

package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.handler.Command;
import com.eomcs.util.Prompt;

public class ClientApp {

  Scanner sc = new Scanner(System.in);
  Prompt prompt = new Prompt(sc);

  public void service() {

    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();
    HashMap<String, Command> commandMap = new HashMap<>();
    String command;

    while (true) {
      command = prompt.inputString("명령> ");

      if (command.length() == 0)
        continue;

      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        System.out.println();
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        System.out.println();
        continue;
      }
      commandStack.push(command);
      commandQueue.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
          System.out.println();
        }
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }
    sc.close();

  }

  private void printCommandHistory(Iterator<String> iter) {
    Iterator<String> iterator = iter;
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if (++count % 5 == 0) {
        System.out.print(" : ");
        String str = sc.nextLine();
        if (str.equalsIgnoreCase("q"))
          break;
      }
    }
  }

  public static void main(String[] args) throws Exception {

    System.out.println("클라이언트 수업 관리 시스템입니다.");

    ClientApp app = new ClientApp();
    app.service();

    /*
     * String serverAddr = null; int port = 0; Scanner sc = new Scanner(System.in);
     * 
     * try { System.out.print("서버? "); serverAddr = sc.nextLine(); System.out.print("포트? "); port =
     * Integer.parseInt(sc.nextLine()); } catch (Exception e) {
     * System.out.println("서버 주소 혹은 포트 번호가 유효하지 않습니다."); sc.close(); return; }
     * 
     * try (Socket socket = new Socket(serverAddr, port); // 서버 연결 // 소켓을 통해 데이터 읽고 쓰는 도구 준비
     * PrintStream out = new PrintStream(socket.getOutputStream()); Scanner in = new
     * Scanner(socket.getInputStream());) { System.out.println("서버와 연결되었습니다.");
     * System.out.print("메시지: "); String sendMsg = sc.nextLine(); // 서버에 메시지 전송 // => 서버로부터 메시지를 받을
     * 때 까지 리턴X : Blocking 방식 동작 out.println(sendMsg); System.out.println("서버에 메시지를 전송하였습니다.");
     * 
     * // 서버에서 메시지 수신 및 출력 String message = in.nextLine(); System.out.println("서버에서 메시지를 수신하였습니다.");
     * System.out.println("서버: " + message); System.out.println("서버와 연결을 끊었습니다."); } catch
     * (Exception e) { System.out.print("예외발생: "); e.printStackTrace(); } sc.close();
     */
  }
}
