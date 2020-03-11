package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonUpdateServlet implements Servlet {

  LessonDao lessonDao;

  public LessonUpdateServlet(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");
    Lesson old = lessonDao.findByNo(no);

    Lesson lesson = new Lesson();

    lesson.setNo(no);

    lesson.setTitle(Prompt.getString(in, out, String.format("수업명(%s)? ", old.getTitle())));
    lesson
        .setDescription(Prompt.getString(in, out, String.format("설명(%s)? ", old.getDescription())));
    lesson.setStartDate(Prompt.getDate(in, out, String.format("시작일(%s)?", old.getStartDate())));
    lesson.setEndDate(Prompt.getDate(in, out, String.format("종료일(%s)? ", old.getEndDate())));
    lesson.setTotalHours(Prompt.getInt(in, out, String.format("총수업시간(%d)? ", old.getTotalHours())));
    lesson.setDayHours(Prompt.getInt(in, out, String.format("일수업시간(%d)? ", old.getDayHours())));
    if (lessonDao.update(lesson) > 0) {
      out.println("수업 정보를 변경했습니다.");
    } else {
      out.println("수업 변경에 실패했습니다.");
    }
  }
}
