package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  final static int size = 5000;
  static User[] users = new User[size];
  static int count = 0;

  public static void main(String[] args) {

    inputUsers();
    printUsers();

  }

  private static void inputUsers() {

    Scanner sc = new Scanner(System.in);

    for (int i = 0 ; i < size ; i++) {
      User u = new User();
      System.out.print("번호? ");
      u.num = sc.nextInt();
      sc.nextLine();
      System.out.print("이름? ");
      u.name = sc.nextLine();
      System.out.print("이메일? ");
      u.email = sc.nextLine();
      System.out.print("암호? ");
      u.pw = sc.nextLine();
      System.out.print("사진? ");
      u.pic = sc.nextLine();
      System.out.print("전화? ");
      u.tel = sc.nextLine();
      System.out.print("가입일? ");
      u.registeredDate = Date.valueOf(sc.next());
      System.out.println();
      users[i] = u;
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
  }

  private static void printUsers() {
    for (int j = 0 ; j < count ; j++) {
      User u1 = users[j];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          u1.num, u1.name, u1.email, u1.tel, u1.registeredDate);
    }
  }
}
