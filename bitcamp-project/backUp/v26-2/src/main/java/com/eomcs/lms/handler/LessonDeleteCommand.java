package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonDeleteCommand implements Command {

  Prompt prompt;
  List<Lesson> lessonList;

  public LessonDeleteCommand(Prompt prompt, List<Lesson> list) {
    this.prompt = prompt;
    this.lessonList = list;
  }

  @Override
  public void execute() {
    int no = prompt.inputInt("강의 번호? ");
    int index = indexOfLesson(no);

    if (index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      System.out.println();
      return;
    }
    this.lessonList.remove(index);
    System.out.println("수업을 삭제했습니다.");
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
