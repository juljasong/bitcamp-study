package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {

  int member_count = 0; 
  Member[] members;
  
  static final int SIZE = 5000;
  public Scanner input;
  
  public MemberHandler (Scanner input) {
    this.input = input;
    this.members = new Member[SIZE];
  }

  public void memberAdd() {
    Member m = new Member();
    System.out.print("번호? ");
    m.no = input.nextInt();
    input.nextLine();
    System.out.print("이름? ");
    m.name = input.nextLine();
    System.out.print("이메일? ");
    m.email = input.nextLine();
    System.out.print("암호? ");
    m.password = input.nextLine();
    System.out.print("사진? ");
    m.photo = input.nextLine();
    System.out.print("전화? ");
    m.tel = input.nextLine();
    System.out.print("가입일? ");
    m.registeredDate = new Date(System.currentTimeMillis());
    System.out.println(m.registeredDate);
    this.members[this.member_count ++] = m;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void memberList() {
    for (int i = 0 ; i < this.member_count ; ) {
      Member m = this.members[i++];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.no, m.name, m.email, m.tel, m.registeredDate);
    }
    System.out.println();
  }

}
