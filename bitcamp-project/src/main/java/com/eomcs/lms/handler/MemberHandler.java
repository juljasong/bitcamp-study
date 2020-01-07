package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;

public class MemberHandler {

  public Scanner input;
  ArrayList<Member> memberList;
  
  public MemberHandler (Scanner input) {
    this.input = input;
    this.memberList = new ArrayList<>();
  }

  public void addMember() {
    Member m = new Member();
    System.out.print("번호? ");
    m.setNo(input.nextInt());
    input.nextLine();
    System.out.print("이름? ");
    m.setName(input.nextLine());
    System.out.print("이메일? ");
    m.setEmail(input.nextLine());
    System.out.print("암호? ");
    m.setPassword(input.nextLine()); 
    System.out.print("사진? ");
    m.setPhoto(input.nextLine()); 
    System.out.print("전화? ");
    m.setTel(input.nextLine()); 
    System.out.print("가입일? ");
    m.setRegisteredDate(new Date(System.currentTimeMillis())); 
    System.out.println(m.getRegisteredDate());
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
    System.out.print("회원 번호? ");
    Member member = this.memberList.get(input.nextInt());
    input.nextLine();
    if (member == null) {
      System.out.println("해당 학생을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    System.out.println("이름 : " + member.getName());
    System.out.println("이메일 : " + member.getEmail());
    System.out.println("암호: " + member.getPassword());
    System.out.println("사진: " + member.getPhoto());
    System.out.println("전화: " + member.getTel());
    System.out.println("가입일: " + member.getRegisteredDate());
    System.out.println();
  }

  public void updateMember() {
    String s;
    System.out.print("회원 번호? ");
    Member member = this.memberList.get(input.nextInt());
    input.nextLine();
    if (member == null) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    System.out.printf("이름(%s)? ", member.getName());
    s = input.nextLine();
    if(s.length() != 0) {
      member.setName(s);
    }
    System.out.printf("이메일(%s)? ", member.getEmail());
    s = input.nextLine();
    if(s.length() != 0) {
      member.setEmail(s);
    }
    System.out.printf("암호(%s)? ", member.getPassword());
    s = input.nextLine();
    if(s.length() != 0) {
      member.setPassword(s);
    }
    System.out.printf("사진(%s)? ", member.getPhoto());
    s = input.nextLine();
    if(s.length() != 0) {
      member.setPhoto(s);
    }
    System.out.printf("전화(%s)? ", member.getTel());
    s = input.nextLine();
    if(s.length() != 0) {
      member.setTel(s);;
    }
    System.out.println("회원을 변경했습니다.");
    System.out.println();
    
  }

  public void deleteMember() {
    System.out.print("회원 번호? ");
    int index = input.nextInt();
    input.nextLine();
    Member member = this.memberList.get(index);
    if(member == null) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    this.memberList.remove(index);
    System.out.println("회원을 삭제했습니다.");
    System.out.println();
    
  }

}
