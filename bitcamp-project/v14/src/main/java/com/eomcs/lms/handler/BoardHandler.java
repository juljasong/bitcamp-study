package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  

  int board_count = 0; 
  Board[] boards;
  // 이전까지 게시물 데이터를 입력받을 때 키보드에서 입력받았지만, 향후 네트워크나 파일로부터도 입력받을 수 있음.
  // 게시판마다 입력받는 방식을 다르게 할 수 있도록 인스턴스 변수로 선언
  Scanner input;

  static final int SIZE = 5000;
  
  // 생성자(Constructor)
  // => 인스턴스를 생성할 때 반드시 호출되는 메소드
  // => new 명령 실행할 때, 호출할 생성자를 지정할 수 있다
  // => 주로 의존 객체를 초기화시키는 코드를 넣는다
  // => 생성자는 리턴 값이 없고, 클래스 이름과 같은 이름으로 메소드를 정의한다.
  public BoardHandler(Scanner input) {
    // BoardHandler 실행하려면 데이터를 입력받는 도구가 반드시 있어야 한다.
    // 이런 도구를 "의존 객체 dependency (object)"라 한다.
    // 생성자는 인스턴스를 생성할 때 의존객체를 반드시 초기화시키도록 한다.
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
          board.no, board.title, board.date, board.viewCount);
    }
    System.out.println();
  }

  public void boardAdd() {
    Board b = new Board();
    System.out.print("번호? ");
    b.no = input.nextInt();
    input.nextLine(); 
    System.out.print("내용? ");
    b.title = input.nextLine();
    b.date = new Date(System.currentTimeMillis());
    b.viewCount = 0;
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
      if(this.boards[i].no == no) {
        board = this.boards[i];
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
