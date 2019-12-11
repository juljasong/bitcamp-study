package com.bitcamp.myproject;

import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int bbsNum = 1;
    System.out.print("제목 : ");
    String bbsName = sc.nextLine();
    String bbsDate = "2019-12-10";
    int bbsHits = 0;
    sc.close();
    System.out.println();
    System.out.printf("게시글 번호 : %d\n", bbsNum);
    System.out.printf("제목 : %s\n", bbsName);
    System.out.printf("작성일자 : %s\n", bbsDate);
    System.out.printf("조회수 : %s\n", bbsHits);
  }

}
