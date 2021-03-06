package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailServlet implements Servlet {

  LessonDao lessonDao;

  public LessonDetailServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호?\n!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    Lesson lesson = lessonDao.findByNo(no);

    if (lesson != null) {
      out.printf("수업명: %s\n", lesson.getTitle());
      out.printf("설명: %s\n", lesson.getDescription());
      out.printf("시작일: %s\n", lesson.getStartDate());
      out.printf("종료일: %s\n", lesson.getEndDate());
      out.printf("총수업시간: %d\n", lesson.getTotalHours());
      out.printf("일수업시간: %d\n", lesson.getDayHours());

    } else {
      out.println("해당 번호의 수업이 없습니다.");
    }
  }
}
