package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardListServlet implements Servlet {

  List<Board> boards;

  public BoardListServlet(List<Board> boards) {
    this.boards = boards;
  }


  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset(); // 기존에 출력했던 List<Board> 객체의 직렬화 데이터 무시하고 새로 직렬화 수행
    out.writeObject(boards);

  }
}
