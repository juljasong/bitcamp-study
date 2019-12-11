package com.eomcs.lms;

import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      System.out.print("번호? ");
      int num = sc.nextInt();
      sc.nextLine();
      System.out.print("내용? ");
      String text = sc.nextLine();
      System.out.println();
      System.out.println("번호 : " + num);
      System.out.println("내용 : " + text);
      System.out.println("작성일: 2019-01-01");
      System.out.println("조회수: 0");
    }
}
