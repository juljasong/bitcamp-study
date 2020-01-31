// listBoard() 메서드 변경
// => toArray() 대신 iterator()를 사용하여 목록 출력

package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardDeleteCommand implements Command {

  List<Board> boardList;
  public Prompt prompt;

  public BoardDeleteCommand(Prompt prompt, List<Board> list) {
    this.prompt = prompt;
    this.boardList = list;
  }

  @Override
  public void execute() {
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
    for (int i = 0; i < this.boardList.size(); i++) {
      if (this.boardList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
