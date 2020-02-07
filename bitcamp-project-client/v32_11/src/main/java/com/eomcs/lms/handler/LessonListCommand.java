package com.eomcs.lms.handler;

import java.util.List;
import com.eomcs.lms.dao.proxy.LessonDaoProxy;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  LessonDaoProxy lessonDao;

  public LessonListCommand(LessonDaoProxy lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    try {
      List<Lesson> lessons = lessonDao.findAll();
      for (Lesson l : lessons) {
        System.out.printf("%d, %s, %s ~ %s, %d\n", l.getNo(), l.getTitle(), l.getStartDate(),
            l.getEndDate(), l.getTotalHours());
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}


