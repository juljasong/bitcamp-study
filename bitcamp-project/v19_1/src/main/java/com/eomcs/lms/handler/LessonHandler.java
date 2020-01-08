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


  public void addLesson() {
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

  public void listLesson() {
    Lesson[] arr = this.lessonList.toArray(new Lesson[this.lessonList.size()]); //lessonList.toArray(Lesson[].class);
    for (Lesson l : arr) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.getNum(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
    System.out.println();
  }


  public void detailLesson() {
    System.out.print("강의 번호? ");
    Lesson lesson = this.lessonList.get(input.nextInt());
    input.nextLine();

    if(lesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      System.out.println();
      return;
    }

    System.out.println("수업명: " + lesson.getTitle());
    System.out.println("수업내용: " + lesson.getDescription());
    System.out.printf("기간 : %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.println("총수업시간: " + lesson.getTotalHours());
    System.out.println("일수업시간: " + lesson.getDayHours());
    System.out.println();
  }


  public void updateLesson() {
    boolean changed = false;
    String s = null;
    System.out.print("강의 번호? ");
    Lesson lesson = this.lessonList.get(input.nextInt());
    if(lesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    input.nextLine();
    System.out.printf("수업명(%s)? ", lesson.getTitle());
    s = input.nextLine();
    if(s.length() != 0) {
      lesson.setTitle(s);
      changed = true;
    }
    System.out.print("수업내용? ");
    s = input.nextLine();
    if(s.length() != 0) {
      lesson.setDescription(s);
      changed = true;
    }
    System.out.printf("시작일(%s)? ", lesson.getStartDate());
    s = input.nextLine();
    if(s.length() != 0) {
      lesson.setStartDate(Date.valueOf(s));
      changed = true;
    }
    System.out.printf("종료일(%s)? ", lesson.getEndDate());
    s = input.nextLine();
    if(s.length() != 0) {
      lesson.setEndDate(Date.valueOf(s));
      changed = true;
    }
    System.out.printf("총수업시간(%d)? ", lesson.getTotalHours());
    s = input.nextLine();
    if(s.length() != 0) {
      lesson.setTotalHours(Integer.parseInt(s));
      changed = true;
    }
    System.out.printf("일수업시간(%s)? ", lesson.getDayHours());
    s = input.nextLine();
    if(s.length() != 0) {
      lesson.setTotalHours(Integer.parseInt(s));
      changed = true;
    }
    if(changed == false) {
      System.out.println("수업 변경을 취소했습니다.");
    } else {
      System.out.println("수업을 변경했습니다.");
    }
    System.out.println();
  }


  public void deleteLesson() {
    System.out.print("강의 번호? ");
    int index = input.nextInt();
    input.nextLine();
    Lesson lesson = this.lessonList.get(index);
    if(lesson == null) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    this.lessonList.remove(index);
    System.out.println("수업을 삭제했습니다.");
    System.out.println();
  }

}
