package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberAddCommand implements Command {
  Prompt prompt;
  List<Member> memberList;

  public MemberAddCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
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
    memberList.add(m);
    System.out.println("저장하였습니다.");
    System.out.println();
  }

}
