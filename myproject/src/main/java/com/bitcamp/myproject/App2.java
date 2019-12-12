package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int userNum = 1;      
      System.out.print("이메일 : ");
      String userEmail = sc.nextLine();
      System.out.print("비밀번호 : ");
      String userPW = sc.nextLine();
      System.out.print("회원명 : ");
      String userName = sc.nextLine();
      System.out.print("가입일 : ");
      Date userResisteredDate = Date.valueOf(sc.nextLine());
      sc.close();
      System.out.println();
      System.out.printf("회원번호 : %d\n", userNum);
      System.out.printf("이메일 : %s\n", userEmail);
      System.out.printf("비밀번호 : %s\n", userPW);
      System.out.printf("회원명 : %s\n", userName);
      System.out.printf("가입일 : %s\n", userResisteredDate);
    }
}
