package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonAddServlet implements Servlet {

  LessonDao lessonDao;

  public LessonAddServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Lesson lesson = new Lesson();
    out.println("수업명? \n!{}!");
    lesson.setTitle(in.nextLine());
    out.println("설명? \n!{}!");
    lesson.setDescription(in.nextLine());
    out.println("시작일? \n!{}!");
    lesson.setStartDate(Date.valueOf(in.nextLine()));
    out.println("종료일? \n!{}!");
    lesson.setEndDate(Date.valueOf(in.nextLine()));
    out.println("총수업시간? \n!{}!");
    lesson.setTotalHours(Integer.parseInt(in.nextLine()));
    out.println("일수업시간? \n!{}!");
    lesson.setDayHours(Integer.parseInt(in.nextLine()));
    out.flush();

    if (lessonDao.insert(lesson) > 0) {
      out.println("새로운 수업을 등록했습니다.");
    } else {
      out.println("수업 등록에 실패했습니다.");
    }
  }
}
