package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  int lesson_count = 0;
  Lesson[] lessons;

  static final int SIZE = 5000;
  public Scanner input;

  public LessonHandler(Scanner input){
    this.input = input;
    this.lessons = new Lesson[SIZE];
  }


  public  void lessonAdd() {
    Lesson l = new Lesson();
    System.out.print("번호? ");
    l.setNum(input.nextInt());
    input.nextLine();
    System.out.print("수업명? ");
    l.setTitle(input.nextLine());
    System.out.print("설명? ");
    l.setDescription(input.nextLine());
    System.out.print("시작일? ");
    l.setStartDate(Date.valueOf(input.next()));
    System.out.print("종료일? ");
    l.setEndDate(Date.valueOf(input.next()));
    System.out.print("총수업시간? ");
    l.setTotalHours(input.nextInt());
    System.out.print("일수업시간? ");
    l.setDayHours(input.nextInt());
    input.nextLine();
    this.lessons[this.lesson_count++] = l;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void lessonList() {
    for (int i = 0 ; i < this.lesson_count ; ) {
      Lesson l = this.lessons[i++];
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.getNum(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
    System.out.println();
  }

}
