package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonAddServlet implements Servlet {

  LessonDao lessonDao;

  public LessonAddServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Lesson lesson = new Lesson();
    lesson.setTitle(Prompt.getString(in, out, "수업명? "));
    lesson.setDescription(Prompt.getString(in, out, "설명? "));
    lesson.setStartDate(Prompt.getDate(in, out, "시작일? "));
    lesson.setEndDate(Prompt.getDate(in, out, "종료일? "));
    lesson.setTotalHours(Prompt.getInt(in, out, "총수업시간? "));
    lesson.setDayHours(Prompt.getInt(in, out, "일수업시간? "));
    out.flush();

    if (lessonDao.insert(lesson) > 0) {
      out.println("새로운 수업을 등록했습니다.");
    } else {
      out.println("수업 등록에 실패했습니다.");
    }
  }
}
