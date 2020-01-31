package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberDetailCommand implements Command {
  Prompt prompt;
  List<Member> memberList;

  public MemberDetailCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
  }

  @Override
  public void execute() {
    int index = indexOfMember(prompt.inputInt("회원 번호? "));
    if (index == -1) {
      System.out.println("해당 학생을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    Member Member = this.memberList.get(index);
    System.out.println("이름 : " + Member.getName());
    System.out.println("이메일 : " + Member.getEmail());
    System.out.println("암호: " + Member.getPassword());
    System.out.println("사진: " + Member.getPhoto());
    System.out.println("전화: " + Member.getTel());
    System.out.println("가입일: " + Member.getRegisteredDate());
    System.out.println();
  }

  private int indexOfMember(int no) {
    for (int i = 0; i < this.memberList.size(); i++) {
      if (this.memberList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
