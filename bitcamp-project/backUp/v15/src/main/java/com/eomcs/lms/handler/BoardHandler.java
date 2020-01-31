package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  

  int board_count = 0; 
  Board[] boards;
  Scanner input;
  static final int SIZE = 5000;
  public BoardHandler(Scanner input) {
    this.input = input;
    this.boards = new Board[SIZE];
  }
  
  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    if (capacity < SIZE || capacity > 10000)
      this.boards = new Board[SIZE];
    else
      this.boards = new Board[capacity];
  } 
  
 
  public  void boardList() {
    for (int i = 0; i < this.board_count; i++) {
      Board board = this.boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          board.getNo(), board.getTitle(), board.getDate(), board.getViewCount());
    }
    System.out.println();
  }

  public void boardAdd() {
    Board b = new Board();
    System.out.print("번호? ");
    b.setNo(input.nextInt()) ;
    input.nextLine(); 
    System.out.print("내용? ");
    b.setTitle(input.nextLine()) ;
    b.setDate(new Date(System.currentTimeMillis()));
    b.setViewCount(0);
    System.out.println("저장하였습니다.");
    System.out.println();
    this.boards[this.board_count++] = b;
  }

  public void detailBoard() {
    System.out.print("게시물 번호? ");
    int no = input.nextInt();
    input.nextLine();

    Board board = null;
    for (int i = 0; i < this.board_count ; i++) {
      if(this.boards[i].getNo() == no) {
        board = this.boards[i];
        break;
      }
      if (board == null) {
        System.out.println("게시물 번호가 유효하지 않습니다.");
        return;
      }
    }
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
    System.out.println();
  }

}
