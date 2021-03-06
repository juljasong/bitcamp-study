package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberUpdateCommand implements Command {
  Prompt prompt;
  List<Member> memberList;

  public MemberUpdateCommand(Prompt prompt, List<Member> list) {
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
    Member oldMember = this.memberList.get(index);
    Member newMember = new Member();
    newMember.setNo(oldMember.getNo());

    newMember.setName(
        prompt.inputString(String.format("이름(%s)? ", oldMember.getName()), oldMember.getName()));
    newMember.setEmail(
        prompt.inputString(String.format("이메일(%s)? ", oldMember.getEmail()), oldMember.getEmail()));
    newMember.setPassword(prompt.inputString(String.format("암호(%s)? ", oldMember.getPassword()),
        oldMember.getPassword()));
    newMember.setPhoto(
        prompt.inputString(String.format("사진(%s)? ", oldMember.getPhoto()), oldMember.getPhoto()));
    newMember.setTel(
        prompt.inputString(String.format("전화(%s)? ", oldMember.getTel()), oldMember.getTel()));
    newMember.setRegisteredDate(oldMember.getRegisteredDate());
    this.memberList.set(index, newMember);

    if (oldMember.equals(newMember)) {
      System.out.println("회원 변경을 취소하였습니다.");
    } else {
      System.out.println("회원을 변경했습니다.");
    }
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
