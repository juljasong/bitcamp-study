// LMS 클라이언트
package com.eomcs.lms;

import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.util.Prompt;

public class ClientApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  Deque<String> commandStack;
  Queue<String> commandQueue;

  public ClientApp() throws Exception { // 생성자 : 객체가 작업할 때 사용할 자원들을 준비
    commandStack = new ArrayDeque<>();
    commandQueue = new LinkedList<>();

  }

  public void service() {

    String command;
    while (true) {
      command = prompt.inputString("\n명령> ");

      if (command.length() == 0)
        continue;

      if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      } else if (command.equals("quit")) {
        break;
      }
      commandStack.push(command);
      commandQueue.offer(command);

      processCommand(command);
    }
    keyboard.close();
  }

  private void processCommand(String command) {
    // 명령어 형식 변경
    String host = null;
    int port = 9999;
    String servletPath = null;

    // 명령어 분석하여 서버주소, 포트번호, 실행할 작업 경로 분리
    // ex) bitcamp://localhost:9999/board/list
    try {
      if (!command.startsWith("bitcamp://")) {
        throw new Exception("명령어 형식이 옳지 않습니다.");
      }

      String url = command.substring(10);
      System.out.println(url); // localhost:9999/board/list

      int index = url.indexOf('/');
      String[] str = url.substring(0, index).split(":");
      host = str[0];

      if (str.length == 2) {
        port = Integer.parseInt(str[1]);
      }
      // System.out.printf("=> %s:%d \n", host, port);
      servletPath = url.substring(index);
      System.out.printf("=> %s\n", servletPath);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return;
    }

    // Connect to Server
    try (Socket socket = new Socket(host, port);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())) {

      out.println(servletPath);
      out.flush();

      while (true) {
        String response = in.nextLine();
        if (response.equals("!end!")) {
          break;
        }
        System.out.println(response);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        String str = prompt.inputString(":");
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 수업 관리 시스템입니다.");

    ClientApp app = new ClientApp();
    app.service();
  }
}
