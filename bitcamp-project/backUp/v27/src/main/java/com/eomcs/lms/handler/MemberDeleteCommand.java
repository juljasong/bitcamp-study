package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberDeleteCommand implements Command {
  Prompt prompt;
  List<Member> memberList;

  public MemberDeleteCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
  }

  @Override
  public void execute() {
    int index = indexOfMember(prompt.inputInt("회원 번호? "));
    if (index == -1) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      System.out.println();
      return;
    }

    this.memberList.remove(index);
    System.out.println("회원을 삭제했습니다.");
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
