package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int size = 5000;
    String[] bbsName = new String[size];
    String[] bbsText = new String[size];
    Date[] today = new Date[size];
    int[] bbsNum = new int[size];
    int[] bbsHits = new int[size];
    int count = 0;
    
    for(int i = 0 ; i < size ; i++) {
    bbsNum[i] = i+1;
    System.out.print("제목 : ");
    bbsName[i] = sc.nextLine();
    System.out.print("내용 : ");
    bbsText[i] = sc.nextLine();
    today[i] = new Date(System.currentTimeMillis());
    bbsHits[i] = 0;
    count++;
    System.out.println();
    System.out.print("계속 입력하시겠습니까?(Y|N) ");
    String res = sc.nextLine();
    if (res.equalsIgnoreCase("Y")) {
      continue;
    } else {
      System.out.println();
    sc.close();
    break;
    }
    }
    for (int j = 0 ; j < count ; j++) {
      System.out.printf("[%d] %s | %s | %s | %d \n",
          bbsNum[j], bbsName[j], bbsText[j], today[j], bbsHits[j]);
    }
    /*
    System.out.println();
    System.out.printf("게시글 번호 : %d\n", bbsNum);
    System.out.printf("제목 : %s\n", bbsName);
    System.out.printf("내용 : %s\n", bbsText);
    System.out.printf("작성일자: %1$tY-%1$tm-%1$td\n", today);
    System.out.printf("조회수 : %s\n", bbsHits);
    */
  }

}
