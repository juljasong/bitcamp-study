// listBoard() 메서드 변경
// => toArray() 대신 iterator()를 사용하여 목록 출력

package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;

  public BoardListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {
    try {
      out.writeUTF("/board/list");
      out.flush(); // 서버에 데이터를 즉시 전송하도록 버퍼의 내용을 내보낸다
      // println()와 writeUTF()의 차이 :
      // println()를 호출할 때는 데이터 뒤에 줄바꿈 코드가 붙음
      // 줄바꿈 코드가 있으면 출력 스트림은 자동으로 flush() 수행
      // -> NIC(랜카드) 버퍼에 보관된 데이터가 전송됨
      // But, writeUTF()의 경우, flush()가 자동으로 수행되지 않기 때문에 데이터를 즉시 전송하고 싶다면
      // 명시적으로 flush()를 호출해주어야 한다.
      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      List<Board> boards = (List<Board>) in.readObject();
      for (Board b : boards) {
        System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(),
            b.getViewCount());
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생.");
    }
  }
}
