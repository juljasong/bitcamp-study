package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  ArrayList<Lesson> lessonList;
  public Scanner input;

  public LessonHandler(Scanner input){
    this.input = input;
    this.lessonList = new ArrayList<>();
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
    // 수업 객체 모록 복사 받을 배열 준비, toArray() 실행.
    // toArray()의 리턴값은 파라미터로 넘겨준 배열의 주소이다.
    Lesson[] arr = this.lessonList.toArray(new Lesson[this.lessonList.getSize()]); //lessonList.toArray(Lesson[].class);
    for (Lesson l : arr) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.getNum(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
    System.out.println();
  }

}
