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
          lh.lessonAdd();
          break;
        case "/lesson/list" :
          lh.lessonList();
          break;
        case "/member/add" :
          mh.memberAdd();
          break;
        case "/member/list" :
          mh.memberList();
          break;
        case "/board/add" :
          게시판1.boardAdd();
          break;
        case "/board/list" :
          게시판1.boardList();
          break;
        case "/board/detail" :
          게시판1.detailBoard();
          break;
        case "/board2/add" :
          게시판2.boardAdd();
          break;
        case "/board2/list" :
          게시판2.boardList();
          break;
        case "/board2/detail" :
          게시판2.detailBoard();
          break;
        case "/board3/add" :
          게시판3.boardAdd();
          break;
        case "/board3/list" :
          게시판3.boardList();
          break;
        case "/board3/detail" :
          게시판3.detailBoard();
          break;
        case "/board4/add" :
          게시판4.boardAdd();
          break;
        case "/board4/list" :
          게시판4.boardList();
          break;
        case "/board4/detail" :
          게시판4.detailBoard();
          break;
        case "/board5/add" :
          게시판5.boardAdd();
          break;
        case "/board5/list" :
          게시판5.boardList();
          break;
        case "/board5/detail" :
          게시판5.detailBoard();
          break;
        case "/board6/add" :
          게시판6.boardAdd();
          break;
        case "/board6/list" :
          게시판6.boardList();
          break;
        case "/board6/detail" :
          게시판6.detailBoard();
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