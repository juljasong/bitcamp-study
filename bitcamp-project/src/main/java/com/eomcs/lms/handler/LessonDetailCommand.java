package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonDetailCommand implements Command {


  List<Lesson> lessonList;
  Prompt prompt;

  public LessonDetailCommand(Prompt prompt, List<Lesson> list) {
    this.prompt = prompt;
    this.lessonList = list;
  }

  @Override
  public void execute() {
    int index = indexOfLesson(prompt.inputInt("강의 번호? "));
    if (index == -1) {
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

  private int indexOfLesson(int no) {
    for (int i = 0; i < this.lessonList.size(); i++) {
      if (this.lessonList.get(i).getNum() == no) {
        return i;
      }
    }
    return -1;
  }

}
