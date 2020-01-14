package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.AbstractList;
import com.eomcs.util.Prompt;

public class LessonHandler {
  
  //ArrayList나 LinkedList를 마음대로 사용할 수 있도록 게시물 목록 관리하는 필드 선언 시,
  // 이들 클래스의 수퍼 클래스로 선언. 대신 이 필드에 들어갈 객체는 생성자에서 파라미터로 받음
  // ArrayList와 LinkedList 둘 다 사용할 수 있어 유지보수에 좋음

  AbstractList<Lesson> lessonList;
  Prompt prompt;

  public LessonHandler(Prompt prompt, AbstractList<Lesson> list){
    this.prompt = prompt;
    this.lessonList = list;
    // Handler가 사용할 List 객체(의존객체: dependency)를 파라미터로 받으면 필요에 따라
    // List 객체를 다른 객체로 대체하기 쉬움
    // 의존 객체를 외부에서 주입받는 것을 "Dependency Injection(의존성 주입) : DI"라 한다
  }


  public void addLesson() {
    Lesson l = new Lesson();
    l.setNum(prompt.inputInt("번호? "));
    l.setTitle(prompt.inputString("수업명? "));
    l.setDescription(prompt.inputString("설명? "));
    l.setStartDate(prompt.inputDate("시작일? "));
    l.setEndDate(prompt.inputDate("종료일? "));
    l.setTotalHours(prompt.inputInt("총수업시간? "));
    l.setDayHours(prompt.inputInt("일수업시간? "));
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
    int index = indexOfLesson(prompt.inputInt("강의 번호? "));
    if(index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    Lesson lesson = this.lessonList.get(index);
    System.out.println("수업명: " + lesson.getTitle());
    System.out.println("수업내용: " + lesson.getDescription());
    System.out.printf("기간 : %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.println("총수업시간: " + lesson.getTotalHours());
    System.out.println("일수업시간: " + lesson.getDayHours());
    System.out.println();
  }


  public void updateLesson() {
    int index = indexOfLesson(prompt.inputInt("강의 번호? "));
    if(index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    Lesson oldLesson = this.lessonList.get(index);
    Lesson newLesson = new Lesson();
    newLesson.setNum(oldLesson.getNum());
    
    // private String inputString(String label, String defaultValue)
    newLesson.setTitle(prompt.inputString
        ( String.format("수업명(%s)? ", oldLesson.getTitle()) , oldLesson.getTitle()));
    newLesson.setDescription(prompt.inputString
        ( String.format("수업내용? ") , oldLesson.getDescription()));
    newLesson.setStartDate(prompt.inputDate
        ( String.format("시작일(%s)? ", oldLesson.getStartDate()) , oldLesson.getStartDate()));
    newLesson.setEndDate(prompt.inputDate
        ( String.format("시작일(%s)? ", oldLesson.getEndDate()) , oldLesson.getEndDate()));
    newLesson.setTotalHours(prompt.inputInt
        ( String.format("총수업시간(%d)? ", oldLesson.getTotalHours()) , oldLesson.getTotalHours()));
    newLesson.setDayHours(prompt.inputInt
        ( String.format("일수업시간(%d)? ", oldLesson.getDayHours()) , oldLesson.getDayHours()));
    
    if(oldLesson.equals(newLesson)) {
      System.out.println("수업 변경을 취소했습니다.");
    } else {
      System.out.println("수업을 변경했습니다.");
    }
    System.out.println();
  }


  public void deleteLesson() {
    int no = prompt.inputInt("강의 번호? ");
    int index = indexOfLesson(no);
    
    if(index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    this.lessonList.remove(index);
    System.out.println("수업을 삭제했습니다.");
    System.out.println();
  }
  
  private int indexOfLesson(int no) {
    for (int i = 0 ; i < this.lessonList.size() ; i++) {
      if(this.lessonList.get(i).getNum() == no) {
        return i;
      }
    }
    return -1;
  }

}
