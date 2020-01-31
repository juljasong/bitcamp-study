package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.BoardHandler2;
import com.eomcs.lms.handler.BoardHandler3;
import com.eomcs.lms.handler.BoardHandler4;
import com.eomcs.lms.handler.BoardHandler5;
import com.eomcs.lms.handler.BoardHandler6;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    LessonHandler.sc = sc;
    BoardHandler.sc = sc;
    MemberHandler.sc = sc;
    BoardHandler2.sc = sc;
    BoardHandler3.sc = sc;
    BoardHandler4.sc = sc;
    BoardHandler5.sc = sc;
    BoardHandler6.sc = sc;

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
        case "/board/detail" :
          BoardHandler.detailBoard();
          break;
        case "/board2/add" :
          BoardHandler2.boardAdd();
          break;
        case "/board2/list" :
          BoardHandler2.boardList();
          break;
        case "/board2/detail" :
          BoardHandler2.detailBoard();
          break;
        case "/board3/add" :
          BoardHandler3.boardAdd();
          break;
        case "/board3/list" :
          BoardHandler3.boardList();
          break;
        case "/board3/detail" :
          BoardHandler3.detailBoard();
          break;
        case "/board4/add" :
          BoardHandler4.boardAdd();
          break;
        case "/board4/list" :
          BoardHandler4.boardList();
          break;
        case "/board4/detail" :
          BoardHandler4.detailBoard();
          break;
        case "/board5/add" :
          BoardHandler5.boardAdd();
          break;
        case "/board5/list" :
          BoardHandler5.boardList();
          break;
        case "/board5/detail" :
          BoardHandler5.detailBoard();
          break;
        case "/board6/add" :
          BoardHandler6.boardAdd();
          break;
        case "/board6/list" :
          BoardHandler6.boardList();
          break;
        case "/board6/detail" :
          BoardHandler6.detailBoard();
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