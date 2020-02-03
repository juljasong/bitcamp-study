package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonUpdateCommand implements Command {


  List<Lesson> lessonList;
  Prompt prompt;

  public LessonUpdateCommand(Prompt prompt, List<Lesson> list) {
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
    Lesson oldLesson = this.lessonList.get(index);
    Lesson newLesson = new Lesson();
    newLesson.setNum(oldLesson.getNum());

    newLesson.setTitle(
        prompt.inputString(String.format("수업명(%s)? ", oldLesson.getTitle()), oldLesson.getTitle()));
    newLesson
        .setDescription(prompt.inputString(String.format("수업내용? "), oldLesson.getDescription()));
    newLesson.setStartDate(prompt.inputDate(String.format("시작일(%s)? ", oldLesson.getStartDate()),
        oldLesson.getStartDate()));
    newLesson.setEndDate(prompt.inputDate(String.format("시작일(%s)? ", oldLesson.getEndDate()),
        oldLesson.getEndDate()));
    newLesson.setTotalHours(prompt.inputInt(String.format("총수업시간(%d)? ", oldLesson.getTotalHours()),
        oldLesson.getTotalHours()));
    newLesson.setDayHours(prompt.inputInt(String.format("일수업시간(%d)? ", oldLesson.getDayHours()),
        oldLesson.getDayHours()));

    if (oldLesson.equals(newLesson)) {
      System.out.println("수업 변경을 취소했습니다.");
    } else {
      System.out.println("수업을 변경했습니다.");
    }
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
