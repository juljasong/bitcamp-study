package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  int lesson_count = 0;
  Lesson[] lessons = new Lesson[SIZE];
  
  static final int SIZE = 5000;
  public static Scanner sc;

  public  void lessonAdd() {
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
    this.lessons[this.lesson_count++] = l;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void lessonList() {
    for (int i = 0 ; i < this.lesson_count ; ) {
      Lesson l = this.lessons[i++];
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.num, l.title, l.startDate, l.endDate, l.totalHours);
    }
    System.out.println();
  }

}
