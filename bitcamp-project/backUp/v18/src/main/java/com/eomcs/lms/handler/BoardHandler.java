package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;

public class BoardHandler {

  ArrayList<Board> boardList;
  Scanner input;

  public BoardHandler(Scanner input) {
    this.input = input;
    this.boardList = new ArrayList<>(); // <Board> 생략 가능
  }

  public BoardHandler(Scanner input, int capacity) {
    this.input = input;
    boardList = new ArrayList<>(capacity);
  } 

  public void boardList() {
    Board[] arr = new Board[this.boardList.getSize()]; 
    this.boardList.toArray(arr); // Board[]의 타입
    for (Board b : arr) {
      if (b == null)
        break;
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
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
    boardList.add(b);
  }

  public void detailBoard() {
    System.out.print("게시물 인덱스? ");
    Board board = boardList.detail(input.nextInt()); 
    input.nextLine();
    
    if (board == null) {
      System.out.println("게시물 번호가 유효하지 않습니다.");
      return;
    }
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
    System.out.println();
  }

}
