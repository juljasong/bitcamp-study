package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberAddCommand implements Command {
  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public MemberAddCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    Member m = new Member();
    m.setNo(prompt.inputInt("번호? "));
    m.setName(prompt.inputString("이름? "));
    m.setEmail(prompt.inputString("이메일? "));
    m.setPassword(prompt.inputString("암호? "));
    m.setPhoto(prompt.inputString("사진? "));
    m.setTel(prompt.inputString("전화? "));
    m.setRegisteredDate(new Date(System.currentTimeMillis()));
    System.out.println();

    try {
      out.writeUTF("/member/add");
      out.writeObject(m);
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
