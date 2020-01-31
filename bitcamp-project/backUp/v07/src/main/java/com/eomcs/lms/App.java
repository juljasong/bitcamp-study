package com.eomcs.lms;

import java.util.Scanner;
import java.sql.Date;

public class App {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    final int SIZE = 5000;
    int count = 0;
    /*
    class Lesson {
      int num, totalHours, dayHours, count;
      String title, description;
      Date startDate, endDate;
    }
    */
    Lesson[] lessons = new Lesson[SIZE];
    for (int i = 0 ; i < SIZE ; i++) {
      lessons[i] = new Lesson();
    }

    for (int i = 0 ; i < SIZE ; i++) {
      Lesson l = lessons[i];
      System.out.print("번호? ");
      l.num = sc.nextInt();
      sc.nextLine();
      System.out.print("수업명? ");
      l.title = sc.nextLine();
      System.out.print("설명? ");
      l.description = sc.nextLine();
      System.out.print("시작일? ");
      l.startDate = Date.valueOf(sc.next());
      System.out.print("종료일? ");
      l.endDate = Date.valueOf(sc.next());
      System.out.print("총수업시간? ");
      l.totalHours = sc.nextInt();
      System.out.print("일수업시간? ");
      l.dayHours = sc.nextInt();
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
      Lesson l = lessons[i];
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.num, l.title, l.startDate, l.endDate, l.totalHours);
    }
  }
}