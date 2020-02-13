package com.eomcs.lms.handler;

import com.eomcs.lms.dao.proxy.LessonDaoProxy;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonUpdateCommand implements Command {

  LessonDaoProxy lessonDao;
  Prompt prompt;

  public LessonUpdateCommand(LessonDaoProxy lessonDao, Prompt prompt) {
    this.lessonDao = lessonDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");

      Lesson oldLesson = lessonDao.findByNo(no);
      Lesson newLesson = new Lesson();

      newLesson.setNo(oldLesson.getNo());

      newLesson.setTitle(prompt.inputString(String.format("수업명(%s)? ", oldLesson.getTitle()),
          oldLesson.getTitle()));

      newLesson.setDescription(prompt.inputString("설명? ", oldLesson.getTitle()));

      newLesson.setStartDate(prompt.inputDate(String.format("시작일(%s)? ", oldLesson.getStartDate()),
          oldLesson.getStartDate()));

      newLesson.setEndDate(prompt.inputDate(String.format("종료일(%s)? ", oldLesson.getEndDate()),
          oldLesson.getEndDate()));

      newLesson.setTotalHours(prompt.inputInt(
          String.format("총수업시간(%d)? ", oldLesson.getTotalHours()), oldLesson.getTotalHours()));

      newLesson.setDayHours(prompt.inputInt(String.format("일수업시간(%d)? ", oldLesson.getDayHours()),
          oldLesson.getDayHours()));

      if (oldLesson.equals(newLesson)) {
        System.out.println("수업 변경을 취소하였습니다.");
        return;
      }
      lessonDao.update(newLesson);
      System.out.println("수업을 변경했습니다.");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}


