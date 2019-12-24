package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  // 인스턴스 필드(non-static field) => new 명령 실행해야 생성되는 변수
  // 개별적으로 관리되어야 하는 값일 경우
  int board_count = 0; 
  Board[] boards = new Board[SIZE];
  
  // 클래스 필드(static field) => Method Area에 클래스 코드가 로딩될 때 자동 생성 
  // 공통으로 관리되어야 하는 값일 경우
  static final int SIZE = 5000;
  public static Scanner sc;
  
  // 클래스 메소드 => 인스턴스 없이 호출하는 메소드, 인스턴스를 사용하려면 파라미터를 통해 호출할 때 외부에서 받아야 함
  public static void boardList(BoardHandler boardHandler) {
    for (int i = 0; i < boardHandler.board_count; i++) {
      Board board = boardHandler.boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          board.no, board.title, board.date, board.viewCount);
    }
    System.out.println();
  }

  public static void boardAdd(BoardHandler boardHandler) {
    Board b = new Board();
    System.out.print("번호? ");
    b.no = sc.nextInt();
    sc.nextLine(); 
    System.out.print("내용? ");
    b.title = sc.nextLine();
    b.date = new Date(System.currentTimeMillis());
    b.viewCount = 0;
    System.out.println("저장하였습니다.");
    System.out.println();
    boardHandler.boards[boardHandler.board_count++] = b;
  }

  public static void detailBoard(BoardHandler boardHandler) {
    System.out.print("게시물 번호? ");
    int no = sc.nextInt();
    sc.nextLine();

    Board board = null;
    for (int i = 0; i < boardHandler.board_count ; i++) {
      if(boardHandler.boards[i].no == no) {
        board = boardHandler.boards[i];
        break;
      }
      if (board == null) {
        System.out.println("게시물 번호가 유효하지 않습니다.");
        return;
      }
    }
    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("등록일: %s\n", board.date);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.println();
  }

}
