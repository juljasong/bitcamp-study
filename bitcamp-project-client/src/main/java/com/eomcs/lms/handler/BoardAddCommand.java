// /board/add 명령어 수행
package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardAddCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public BoardAddCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    Board b = new Board();
    b.setNo(prompt.inputInt("번호? "));
    b.setTitle(prompt.inputString("내용? "));
    b.setDate(new Date(System.currentTimeMillis()));
    b.setViewCount(0);
    System.out.println();
    try {
      out.writeUTF("/board/add");
      out.writeObject(b);
      out.flush();
      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      System.out.println("저장하였습니다.");
    } catch (Exception e) {
      System.out.println("통신 오류 발생");
    }
  }
}
