package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    LessonHandler.sc = sc;
    BoardHandler.sc = sc;
    MemberHandler.sc = sc;
    
    // BoardHandler 메소드가 사용할 메모리만 게시판 마다 따로 생성
    BoardHandler 게시판1 = new BoardHandler();
    BoardHandler 게시판2 = new BoardHandler();
    BoardHandler 게시판3 = new BoardHandler();
    BoardHandler 게시판4 = new BoardHandler();
    BoardHandler 게시판5 = new BoardHandler();
    BoardHandler 게시판6 = new BoardHandler();
    MemberHandler mh = new MemberHandler();
    LessonHandler lh = new LessonHandler();
    
    String command;
    while (true) {
      System.out.print("명령> ");
      command = sc.nextLine();

      switch(command) {
        case "/lesson/add" :
          LessonHandler.lessonAdd(lh);
          break;
        case "/lesson/list" :
          LessonHandler.lessonList(lh);
          break;
        case "/member/add" :
          MemberHandler.memberAdd(mh);
          break;
        case "/member/list" :
          MemberHandler.memberList(mh);
          break;
        case "/board/add" :
          BoardHandler.boardAdd(게시판1);
          break;
        case "/board/list" :
          BoardHandler.boardList(게시판1);
          break;
        case "/board/detail" :
          BoardHandler.detailBoard(게시판1);
          break;
        case "/board2/add" :
          BoardHandler.boardAdd(게시판2);
          break;
        case "/board2/list" :
          BoardHandler.boardList(게시판2);
          break;
        case "/board2/detail" :
          BoardHandler.detailBoard(게시판2);
          break;
        case "/board3/add" :
          BoardHandler.boardAdd(게시판3);
          break;
        case "/board3/list" :
          BoardHandler.boardList(게시판3);
          break;
        case "/board3/detail" :
          BoardHandler.detailBoard(게시판3);
          break;
        case "/board4/add" :
          BoardHandler.boardAdd(게시판4);
          break;
        case "/board4/list" :
          BoardHandler.boardList(게시판4);
          break;
        case "/board4/detail" :
          BoardHandler.detailBoard(게시판4);
          break;
        case "/board5/add" :
          BoardHandler.boardAdd(게시판5);
          break;
        case "/board5/list" :
          BoardHandler.boardList(게시판5);
          break;
        case "/board5/detail" :
          BoardHandler.detailBoard(게시판5);
          break;
        case "/board6/add" :
          BoardHandler.boardAdd(게시판6);
          break;
        case "/board6/list" :
          BoardHandler.boardList(게시판6);
          break;
        case "/board6/detail" :
          BoardHandler.detailBoard(게시판6);
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