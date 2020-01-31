package com.eomcs.lms;

import java.util.Date;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      Date today = new Date(System.currentTimeMillis());
      
      // 현재일시
      // currentTimeMillis()
      // =>1970년 1월 1일 기준 현재까지 경과된 시간을 밀리초로 리턴
      // new Date(밀리초)
      // => 넘겨받은 밀리초를 가지고 년, 월, 일, 시, 분, 초 계산
      
      System.out.print("번호? ");
      int num = sc.nextInt();
      sc.nextLine();
      System.out.print("내용? ");
      String text = sc.nextLine();
      sc.close();
      System.out.println();
      System.out.println("번호 : " + num);
      System.out.println("내용 : " + text);
      System.out.printf("작성일: %1$tY-%1$tm-%1$td\n", today);
      System.out.println("조회수: 0");
    }
}
