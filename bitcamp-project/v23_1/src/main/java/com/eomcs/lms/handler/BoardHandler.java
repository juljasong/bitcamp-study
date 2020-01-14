package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.List;
import com.eomcs.util.Prompt;

public class BoardHandler {

  // ArrayList나 LinkedList를 마음대로 사용할 수 있도록 게시물 목록 관리하는 필드 선언 시,
  // 이들 클래스의 수퍼 클래스로 선언. 대신 이 필드에 들어갈 객체는 생성자에서 파라미터로 받음
  // ArrayList와 LinkedList 둘 다 사용할 수 있어 유지보수에 좋음
  List<Board> boardList;
  public Prompt prompt;

  public BoardHandler(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    this.boardList = list;
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
    b.setNo(prompt.inputInt("번호? "));
    b.setTitle(prompt.inputString("내용? "));
    b.setDate(new Date(System.currentTimeMillis()));
    b.setViewCount(0);
    System.out.println("저장하였습니다.");
    System.out.println();
    boardList.add(b);
  }

  public void detailBoard() {
    int index = indexOfBoard(prompt.inputInt("게시글 번호? "));

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
    int index = indexOfBoard(prompt.inputInt("게시글 번호? "));

    if (index == -1) {
      System.out.println("게시글 번호가 유효하지 않습니다.");
      System.out.println();
      return;
    }

    Board oldBoard = this.boardList.get(index);
    Board newBoard = new Board();
    newBoard.setNo(oldBoard.getNo());

    newBoard.setTitle(prompt.inputString
        ( String.format ("내용(%s)? ", oldBoard.getTitle()) , oldBoard.getTitle()));

    newBoard.setViewCount(oldBoard.getViewCount());
    newBoard.setDate(new Date(System.currentTimeMillis()));
    newBoard.setWriter(oldBoard.getWriter());

    if(oldBoard.equals(newBoard)) {
      System.out.println("수업 변경을 취소했습니다.");
    } else {
      System.out.println("수업을 변경했습니다.");
    }
    System.out.println();

    this.boardList.set(index, newBoard);
  }

  public void deleteBoard() {
    int index = indexOfBoard(prompt.inputInt("게시글 번호? "));

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
