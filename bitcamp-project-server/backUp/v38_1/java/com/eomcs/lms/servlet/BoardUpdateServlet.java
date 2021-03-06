package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateServlet implements Servlet {

  BoardDao boardDao;

  public BoardUpdateServlet(BoardDao boardDao) {
    this.boardDao = boardDao;
  }


  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");
    int no = Integer.parseInt(in.nextLine());
    out.flush();

    Board old = boardDao.findByNo(no);

    if (old == null) {
      out.println("해당 번호의 게시글이 없습니다.");
      return;
    }
    out.printf("제목(%s)? \n!{}!\n", old.getTitle());
    out.flush();
    Board board = new Board();

    board.setTitle(in.nextLine());
    board.setNo(no);

    if (boardDao.update(board) > 0) {
      out.println("게시글을 변경했습니다.");
    } else {
      out.println("게시글 변경에 실패했습니다.");
    }
  }
}
