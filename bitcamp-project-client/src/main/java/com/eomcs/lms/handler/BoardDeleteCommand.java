// listBoard() 메서드 변경
// => toArray() 대신 iterator()를 사용하여 목록 출력

package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.util.Prompt;

public class BoardDeleteCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public BoardDeleteCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int index = prompt.inputInt("게시글 번호? ");
      out.writeUTF("/board/delete");
      out.writeInt(index);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      System.out.println("게시글을 삭제했습니다.");

      if (index == -1) {
        System.out.println("게시글 번호가 유효하지 않습니다.");
        System.out.println();
        return;
      }
      System.out.println("게시글을 삭제했습니다.");
      System.out.println();
    } catch (Exception e) {
      System.out.println("명령 처리 중 오류 발생");
    }
  }

}
