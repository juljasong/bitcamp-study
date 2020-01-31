package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler(sc);
    MemberHandler memberHandler = new MemberHandler(sc);
    LessonHandler lessonHandler = new LessonHandler(sc);

    String command;
    while (true) {
      System.out.print("명령> ");
      command = sc.nextLine();

      switch(command) {
        case "/lesson/add" :
          lessonHandler.lessonAdd();
          break;
        case "/lesson/list" :
          lessonHandler.lessonList();
          break;
        case "/member/add" :
          memberHandler.memberAdd();
          break;
        case "/member/list" :
          memberHandler.memberList();
          break;
        case "/board/add" :
          boardHandler.boardAdd();
          break;
        case "/board/list" :
          boardHandler.boardList();
          break;
        case "/board/detail" :
          boardHandler.detailBoard();
          break;
        case "quit" :
          System.out.println("안녕!");
          sc.close();
          System.exit(0);
        default :
          System.out.println("실행할 수 없는 명령입니다.");
          System.out.println();
          break;
      }
    }
  }

}