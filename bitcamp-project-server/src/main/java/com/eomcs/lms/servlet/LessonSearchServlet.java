package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;
import com.eomcs.util.RequestMapping;

@Component
public class LessonSearchServlet {

  LessonService lessonService;

  public LessonSearchServlet(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping("/lesson/search")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    Map<String, Object> params2 = new HashMap<String, Object>();

    String keyword = params.get("title");
    if (keyword.length() > 0) {
      params2.put("title", keyword);
    }
    keyword = params.get("title");
    if (keyword.length() > 0) {
      params2.put("description", keyword);
    }
    Date date = Date.valueOf(params.get("startDate"));
    if (date != null) {
      params2.put("startDate", date.toString());
    }
    date = Date.valueOf(params.get("endDate"));
    if (date != null) {
      params2.put("endDate", date.toString());
    }
    int value = Integer.parseInt(params.get("dayHours"));
    if (value > 0) {
      params2.put("dayHours", String.valueOf(value));
    }
    value = Integer.parseInt(params.get("totalHours"));
    if (value > 0) {
      params2.put("totalHours", String.valueOf(value));
    }

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>수업 검색 결과</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>수업 검색 결과</h1>");

    List<Lesson> lessons = lessonService.search(params2);

    for (Lesson l : lessons) {
      out.printf(
          "<tr><td>%d</td> <td><a href='/lesson/detail?no=%d'>%s</a></td> <td>%s ~ %s</td> <td>%d</td></tr>\n",
          l.getNo(), l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }

  }
}
