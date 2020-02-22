package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;

public class LessonDeleteServlet implements Servlet {

  LessonDao lessonDao;

  public LessonDeleteServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");
    out.flush();
    int no = Integer.parseInt(in.nextLine());

    if (lessonDao.delete(no) > 0) {
      out.println("해당 번호의 수업을 삭제하였습니다.");
    } else {
      out.println("수업 삭제에 실패했습니다.");
    }
  }
}
