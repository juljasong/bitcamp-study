package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int size = 5000;
    int[] userNum = new int[size]; 
    String[] userEmail = new String[size];
    String[] userPW = new String[size];
    String[] userName = new String[size];
    Date[] userResisteredDate = new Date[size];
    int count = 0;

    for (int i = 0 ; i < size ; i++) {
      userNum[i] = i+1; 
      System.out.print("이메일 : ");
      userEmail[i] = sc.nextLine();
      System.out.print("비밀번호 : ");
      userPW[i] = sc.nextLine();
      System.out.print("회원명 : ");
      userName[i] = sc.nextLine();
      System.out.print("가입일 : ");
      userResisteredDate[i] = Date.valueOf(sc.nextLine());
      count++;
      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y|N) ");
      String res = sc.nextLine();
      if (res.equalsIgnoreCase("Y")) {
        System.out.println();
        continue;
      } else {
        sc.close();
        break;
      }
    }
    System.out.println();
    for (int j = 0 ; j < count ; j++) {
      System.out.printf("[%d] %s | %s | %s\n", 
          userNum[j], userEmail[j], userName[j], userResisteredDate[j]);
      /*
      System.out.printf("회원번호 : %d\n", userNum);
      System.out.printf("이메일 : %s\n", userEmail);
      System.out.printf("비밀번호 : %s\n", userPW);
      System.out.printf("회원명 : %s\n", userName);
      System.out.printf("가입일 : %s\n", userResisteredDate);
       */
    }
  }
}



