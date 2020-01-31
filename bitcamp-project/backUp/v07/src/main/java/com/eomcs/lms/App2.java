package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    final int SIZE = 100; 
    
    /*
    class User {
      int no;
      String name, email, password, photo, tel;
      Date registeredDate;
    }
    */
    User[] users = new User[SIZE];
    
    for (int i = 0 ; i < SIZE ; i++) {
      users[i] = new User();
    }

    int count = 0;
    
    for (int i = 0 ; i < SIZE ; i++) {
      User u = users[i];
      System.out.print("번호? ");
      u.no = sc.nextInt();
      sc.nextLine();
      System.out.print("이름? ");
      u.name = sc.nextLine();
      System.out.print("이메일? ");
      u.email = sc.nextLine();
      System.out.print("암호? ");
      u.password = sc.nextLine();
      System.out.print("사진? ");
      u.photo = sc.nextLine();
      System.out.print("전화? ");
      u.tel = sc.nextLine();
      System.out.print("가입일? ");
      u.registeredDate = new Date(System.currentTimeMillis());
      System.out.print(u.registeredDate);
      System.out.println();

      count++;

      //sc.nextLine();
      System.out.println();
      System.out.print("계속하시겠습니까?(Y/N) ");
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
      User u = users[i];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          u.no, u.name, u.email, u.tel, u.registeredDate);
    }
    
  }
}
