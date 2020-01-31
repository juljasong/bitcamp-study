package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class BoardHandler {
  
  static class Board {
    int no, viewCount;
    String title;
    Date date;
  }
  static final int SIZE = 5000;
  static int board_count = 0; 
  static Board[] boards = new Board[SIZE];
  static Scanner sc;
  
  static void boardList() {
    for (int i = 0; i < board_count; i++) {
      Board board = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          board.no, board.title, board.date, board.viewCount);
    }
    System.out.println();
  }

  static void boardAdd() {
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

}
