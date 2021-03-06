package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class LessonHandler {
  
  static class Lesson {
    int num, totalHours, dayHours, count;
    String title, description;
    Date startDate, endDate;
  }
  static final int SIZE = 5000;
  static int lesson_count = 0;
  static Lesson[] lessons = new Lesson[SIZE];
  static Scanner sc;

  static void lessonAdd() {
    Lesson l = new Lesson();
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
    sc.nextLine();
    lessons[lesson_count++] = l;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  static void lessonList() {
    for (int i = 0 ; i < lesson_count ; ) {
      Lesson l = lessons[i++];
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.num, l.title, l.startDate, l.endDate, l.totalHours);
    }
    System.out.println();
  }

}
