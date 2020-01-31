package com.eomcs.lms;

import java.util.Scanner;

public class App {

  static Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    LessonHandler.sc = sc;
    BoardHandler.sc = sc;
    MemberHandler.sc = sc;

    String command;
    while (true) {
      System.out.print("명령> ");
      command = sc.nextLine();

      switch(command) {
        case "/lesson/add" :
          LessonHandler.lessonAdd();
          break;
        case "/lesson/list" :
          LessonHandler.lessonList();
          break;
        case "/member/add" :
          MemberHandler.memberAdd();
          break;
        case "/member/list" :
          MemberHandler.memberList();
          break;
        case "/board/add" :
          BoardHandler.boardAdd();
          break;
        case "/board/list" :
          BoardHandler.boardList();
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