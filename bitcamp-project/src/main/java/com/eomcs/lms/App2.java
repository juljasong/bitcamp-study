package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      
      System.out.print("번호? ");
      int num = sc.nextInt();
      sc.nextLine();
      System.out.print("이름? ");
      String name = sc.nextLine();
      System.out.print("이메일? ");
      String email = sc.nextLine();
      System.out.print("암호? ");
      String pw = sc.nextLine();
      System.out.print("사진? ");
      String pic = sc.nextLine();
      System.out.print("전화? ");
      String tel = sc.nextLine();
      System.out.print("가입일? ");
      Date registeredDate = Date.valueOf(sc.next());
      sc.close();
      System.out.println();
      System.out.printf("번호 : %d\n", num);
      System.out.printf("이름 : %s\n", name);
      System.out.println("이메일 : " + email);
      System.out.println("암호 : " + pw);
      System.out.println("사진 : " + pic);
      System.out.println("전화 : " + tel);
      System.out.println("가입일 : " + registeredDate);
    }
}
