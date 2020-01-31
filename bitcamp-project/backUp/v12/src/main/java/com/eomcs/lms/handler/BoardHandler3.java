package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler3 {
  
  static final int SIZE = 5000;
  static int board_count = 0; 
  static Board[] boards = new Board[SIZE];
  public static Scanner sc;
  
  public static void boardList() {
    for (int i = 0; i < board_count; i++) {
      Board board = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          board.no, board.title, board.date, board.viewCount);
    }
    System.out.println();
  }

  public static void boardAdd() {
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
    boards[board_count++] = b;
  }
  
  public static void detailBoard() {
    System.out.print("게시물 번호? ");
    int no = sc.nextInt();
    sc.nextLine();

    Board board = null;
    for (int i = 0; i < board_count ; i++) {
      if(boards[i].no == no) {
        board = boards[i];
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
