package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;

public class MemberHandler {

  static class Member {
    int no;
    String name, email, password, photo, tel;
    Date registeredDate;
  }
  static final int SIZE = 5000;
  static int member_count = 0; 
  static Member[] members = new Member[SIZE];
  public static Scanner sc;

  public static void memberAdd() {
    Member m = new Member();
    System.out.print("번호? ");
    m.no = sc.nextInt();
    sc.nextLine();
    System.out.print("이름? ");
    m.name = sc.nextLine();
    System.out.print("이메일? ");
    m.email = sc.nextLine();
    System.out.print("암호? ");
    m.password = sc.nextLine();
    System.out.print("사진? ");
    m.photo = sc.nextLine();
    System.out.print("전화? ");
    m.tel = sc.nextLine();
    System.out.print("가입일? ");
    m.registeredDate = new Date(System.currentTimeMillis());
    System.out.println(m.registeredDate);
    members[member_count++] = m;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public static void memberList() {
    for (int i = 0 ; i < member_count ; ) {
      Member m = members[i++];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.no, m.name, m.email, m.tel, m.registeredDate);
    }
    System.out.println();
  }

}
