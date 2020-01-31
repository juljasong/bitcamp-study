package com.eomcs.lms.handler;

import java.sql.Date;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.LinkedList;
import com.eomcs.util.Prompt;

public class MemberHandler {

  Prompt prompt;
  LinkedList<Member> memberList;

  public MemberHandler (Prompt prompt) {
    this.prompt = prompt;
    this.memberList = new LinkedList<>();
  }

  public void addMember() {
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

  public void listMember() {
    Member[] arr = this.memberList.toArray(new Member[] {});
    for (Member m : arr) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
    }
    System.out.println();
  }

  public void detailMember() {
    int index = indexOfMember(prompt.inputInt("회원 번호? " ));
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

  public void updateMember() {
    int index = indexOfMember(prompt.inputInt("회원 번호? " ));
    if (index == -1) {
      System.out.println("해당 학생을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    Member oldMember = this.memberList.get(index);
    Member newMember = new Member();
    newMember.setNo(oldMember.getNo());
    
    newMember.setName(prompt.inputString
        (String.format("이름(%s)? ", oldMember.getName()), oldMember.getName()));
    newMember.setEmail(prompt.inputString
        (String.format("이메일(%s)? ", oldMember.getEmail()), oldMember.getEmail()));
    newMember.setPassword(prompt.inputString
        (String.format("암호(%s)? ", oldMember.getPassword()), oldMember.getPassword()));
    newMember.setPhoto(prompt.inputString
        (String.format("사진(%s)? ", oldMember.getPhoto()), oldMember.getPhoto()));
    newMember.setTel(prompt.inputString
        (String.format("전화(%s)? ", oldMember.getTel()), oldMember.getTel()));
    newMember.setRegisteredDate(oldMember.getRegisteredDate());
    this.memberList.set(index, newMember);
    
    if(oldMember.equals(newMember)) {
      System.out.println("회원 변경을 취소하였습니다.");
    } else {
      System.out.println("회원을 변경했습니다.");
    }
    System.out.println();

  }

  public void deleteMember() {
    int index = indexOfMember(prompt.inputInt("회원 번호? "));
    if(index == -1) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    
    this.memberList.remove(index);
    System.out.println("회원을 삭제했습니다.");
    System.out.println();
  }
  
  private int indexOfMember(int no) {
    for(int i = 0 ; i < this.memberList.size() ; i++) {
      if(this.memberList.get(i).getNo() == no) {
        return i;
      }
    }
    return -1;
  }

}
