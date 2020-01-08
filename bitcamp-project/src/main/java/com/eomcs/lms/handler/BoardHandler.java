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

  public void ListBoard() {
    Board[] arr = new Board[this.boardList.size()]; 
    this.boardList.toArray(arr); // Board[]의 타입
    for (Board b : arr) {
      if (b == null)
        break;
      System.out.printf("%d, %s, %s, %d\n", 
          b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
    System.out.println();
  }

  public void addBoard() {
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
    System.out.print("게시글 번호? ");
    int no = input.nextInt(); 
    input.nextLine();

    int index = indexOfBoard(no);

    if (index == -1) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      System.out.println();
      return;
    }
    Board board = this.boardList.get(index);
    System.out.printf("번호: %d\n", board.getNo());
    System.out.printf("제목: %s\n", board.getTitle());
    System.out.printf("등록일: %s\n", board.getDate());
    System.out.printf("조회수: %d\n", board.getViewCount());
    System.out.println();
  }

  public void updateBoard() {
    System.out.print("번호? ");
    int no = input.nextInt(); 
    input.nextLine();
    
    int index = indexOfBoard(no); 
   
    if (index == -1) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      System.out.println();
      return;
    }
    Board oldBoard = this.boardList.get(index);
    System.out.printf("내용(%s)? ", oldBoard.getTitle());
    String title = input.nextLine();
    if (title.length() == 0) {
      System.out.println("게시글 변경을 취소했습니다.");
      System.out.println();
      return;
    }

    Board newBoard = new Board();
    newBoard.setNo(oldBoard.getNo());
    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setTitle(title);
    newBoard.setDate(new Date(System.currentTimeMillis()));
    this.boardList.set(index, newBoard);
    System.out.println("게시글을 변경했습니다.");
    System.out.println();
  }

  public void deleteBoard() {
    System.out.print("게시글 번호? ");
    int no = input.nextInt(); 
    input.nextLine();
    int index = indexOfBoard(no);
    
    if (index == -1) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      System.out.println();
      return;
    }    
    this.boardList.remove(index);
    System.out.println("게시글을 삭제했습니다.");
    System.out.println();
  }
  
  private int indexOfBoard(int no) {
    for(int i = 0 ; i < this.boardList.size() ; i++) {
      if(this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }
  
}
