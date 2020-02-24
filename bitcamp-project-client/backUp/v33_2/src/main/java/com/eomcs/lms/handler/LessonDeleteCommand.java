package com.eomcs.lms.handler;

import com.eomcs.lms.dao.proxy.LessonDaoProxy;
import com.eomcs.util.Prompt;

public class LessonDeleteCommand implements Command {

  Prompt prompt;
  LessonDaoProxy lessonDao;

  public LessonDeleteCommand(LessonDaoProxy lessonDao, Prompt prompt) {
    this.lessonDao = lessonDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");
      lessonDao.delete(no);
      System.out.println("수업을 삭제했습니다.");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}


