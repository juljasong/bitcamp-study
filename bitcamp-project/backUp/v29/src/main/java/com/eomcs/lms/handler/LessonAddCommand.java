package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonAddCommand implements Command {


  List<Lesson> lessonList;
  Prompt prompt;

  public LessonAddCommand(Prompt prompt, List<Lesson> list) {
    this.prompt = prompt;
    this.lessonList = list;
  }

  @Override
  public void execute() {
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
}
