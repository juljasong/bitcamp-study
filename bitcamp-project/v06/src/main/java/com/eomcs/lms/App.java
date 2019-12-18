package com.eomcs.lms;

//import java.util.Date;
import java.util.Scanner;
import java.sql.Date;

public class App {


  public static void main(String[] args) {

    final int SIZE = 5000;
    int[] num = new int[SIZE];
    String[] title = new String[SIZE];
    String[] description = new String[SIZE];
    Date[] startDate = new Date[SIZE];
    Date[] endDate = new Date[SIZE];
    int[] totalHours = new int[SIZE];
    int[] dayHours = new int[SIZE];
    int count = 0;

    Scanner sc = new Scanner(System.in);

    for (int i = 0 ; i < SIZE ; i++) {
      System.out.print("번호? ");
      num[i] = sc.nextInt();
      sc.nextLine();
      System.out.print("수업명? ");
      title[i] = sc.nextLine();
      System.out.print("설명? ");
      description[i] = sc.nextLine();
      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(sc.next());
      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(sc.next());
      System.out.print("총수업시간? ");
      totalHours[i] = sc.nextInt();
      System.out.print("일수업시간? ");
      dayHours[i] = sc.nextInt();
      System.out.println();
      count++;
      System.out.print("계속 입력하시겠습니까?(Y/N) ");
      String res = sc.next();
      if(res.equalsIgnoreCase("Y")) {
        System.out.println();
        continue;
      } else
        sc.close();
      break;
    }

    System.out.println();
    for (int i = 0 ; i < count ; i++) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          num[i], title[i], startDate[i], endDate[i], totalHours[i]);
    }
  }
}