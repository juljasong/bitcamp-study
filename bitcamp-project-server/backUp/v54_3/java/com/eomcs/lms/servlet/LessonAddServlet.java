package com.eomcs.lms.servlet;

import java.io.PrintWriter;
import java.sql.Date;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonAddServlet {

  LessonService lessonService;

  public LessonAddServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/add")
  public void service(Map<String, String> params, PrintWriter out) throws Exception {
    Lesson lesson = new Lesson();
    lesson.setTitle(params.get("title"));
    lesson.setDescription(params.get("description"));
    lesson.setStartDate(Date.valueOf(params.get("startDate")));
    lesson.setEndDate(Date.valueOf(params.get("endDate")));
    lesson.setTotalHours(Integer.parseInt(params.get("totalHours")));
    lesson.setDayHours(Integer.parseInt(params.get("dayHours")));
    lessonService.insert(lesson);

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='2;url=/lesson/list'>");
    out.println("<title>수업 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>수업 등록 결과</h1>");
    out.println("<p>새 수업을 등록했습니다.</p>");
    out.println("</body>");
    out.println("</html>");

  }
}
