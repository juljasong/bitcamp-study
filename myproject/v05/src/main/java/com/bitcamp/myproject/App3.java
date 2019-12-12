package com.bitcamp.myproject;

import java.util.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int bbsNum = 1;
    System.out.print("제목 : ");
    String bbsName = sc.nextLine();
    System.out.print("내용 : ");
    String bbsText = sc.nextLine();
    Date today = new Date(System.currentTimeMillis());
    int bbsHits = 0;
    sc.close();
    
    System.out.println();
    System.out.printf("게시글 번호 : %d\n", bbsNum);
    System.out.printf("제목 : %s\n", bbsName);
    System.out.printf("내용 : %s\n", bbsText);
    System.out.printf("작성일자: %1$tY-%1$tm-%1$td\n", today);
    System.out.printf("조회수 : %s\n", bbsHits);
  }

}
