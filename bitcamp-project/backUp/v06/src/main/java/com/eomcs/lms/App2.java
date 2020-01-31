package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    final int SIZE = 100; 
    int[] no = new int[SIZE];
    String[] name = new String[SIZE];
    String[] email = new String[SIZE];
    String[] password = new String[SIZE];
    String[] photo = new String[SIZE];
    String[] tel = new String[SIZE];
    Date[] registeredDate = new Date[SIZE];

    Scanner sc = new Scanner(System.in);
    int count = 0;
    for (int i = 0 ; i < SIZE ; i++) {
      System.out.print("번호? ");
      no[i] = sc.nextInt();
      sc.nextLine();
      System.out.print("이름? ");
      name[i] = sc.nextLine();
      System.out.print("이메일? ");
      email[i] = sc.nextLine();
      System.out.print("암호? ");
      password[i] = sc.nextLine();
      System.out.print("사진? ");
      photo[i] = sc.nextLine();
      System.out.print("전화? ");
      tel[i] = sc.nextLine();
      System.out.print("가입일? ");
      registeredDate[i] = new Date(System.currentTimeMillis());
      System.out.print(registeredDate[i]);
      System.out.println();

      count++;

      System.out.print("계속하시겠습니까?(Y/N) ");
      sc.nextLine();
      String res = sc.nextLine();
      System.out.println();
      if (res.equalsIgnoreCase("Y")) {
        continue;
      } else {
        sc.close();
        break;
      }
    }
    for (int i = 0 ; i < count ; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          no[i], name[i], email[i], tel[i], registeredDate[i]);
    }
    
  }
}
