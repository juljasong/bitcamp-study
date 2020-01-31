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

  public void memberAdd() {
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
  
  // Member 객체의 목록을 저장할 배열을 넘기는데 크기가 0인 배열 넘김
  public void memberList() {
    Member[] arr = this.memberList.toArray(new Member[] {}); //memberList.toArray(Member[].class);
    for (Member m : arr) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
    }
    System.out.println();
  }

}
