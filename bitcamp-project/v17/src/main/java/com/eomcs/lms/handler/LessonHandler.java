package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  ArrayList lessonList;
  public Scanner input;

  public LessonHandler(Scanner input){
    this.input = input;
    lessonList = new ArrayList();
  }


  public void lessonAdd() {
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
    lessonList.add(l);
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  public void lessonList() {
    Object[] arr = lessonList.toArray();
    for (Object obj : arr) {
      Lesson l = (Lesson)obj;
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.getNum(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
    System.out.println();
  }

}
