package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberDetailCommand implements Command {
  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public MemberDetailCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int index = prompt.inputInt("회원 번호? ");
      out.writeUTF("/member/detail");
      out.writeInt(index);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      Member Member = (com.eomcs.lms.domain.Member) in.readObject();
      System.out.println("이름 : " + Member.getName());
      System.out.println("이메일 : " + Member.getEmail());
      System.out.println("암호: " + Member.getPassword());
      System.out.println("사진: " + Member.getPhoto());
      System.out.println("전화: " + Member.getTel());
      System.out.println("가입일: " + Member.getRegisteredDate());

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생");
    }
  }

}
