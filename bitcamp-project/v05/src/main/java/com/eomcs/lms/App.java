package com.eomcs.lms;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
      
      // 키보드에서 사용자가 입력한 값을 읽어 문자열이나 정수, 부동소수점 등으로 리턴
      Scanner sc = new Scanner(System.in); // Object.method(call)
      
      System.out.print("번호? ");
      int num = sc.nextInt(); // = 할당 연산자 == 비교 연산자
      sc.nextLine();
      System.out.print("수업명? ");
      String title = sc.nextLine();
      System.out.print("설명? ");
      String description = sc.nextLine();
      System.out.print("시작일? ");
      String startDate = sc.nextLine(); // 낙타Camel 표기법
      System.out.print("종료일? ");
      String endDate = sc.nextLine();
      System.out.print("총수업시간? ");
      int totalHours = sc.nextInt();
      System.out.print("일수업시간? ");
      int dayHours = sc.nextInt();
      sc.close();
      System.out.println();
      System.out.println("번호: " + num);
      System.out.println("수업명: " + title);
      System.out.println("수업내용: " + description);
      System.out.printf("기간: %s ~ %s \n", startDate, endDate);
      System.out.printf("총수업시간: %d 시간\n", totalHours);
      System.out.printf("일수업시간: %d 시간\n", dayHours);
      
    }
}