package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/list")
public class LessonListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      ServletContext servletContext = request.getServletContext();
      ApplicationContext iocContainer =
          (ApplicationContext) servletContext.getAttribute("iocContainer");

      LessonService lessonService = iocContainer.getBean(LessonService.class);

      List<Lesson> lessons = lessonService.list();

      out.println("<!DOCTYPE html>");
      out.println("<html>");

      out.println("<head>");
      out.println("   <meta charset='UTF-8'>");
      out.println("   <title>수업 목록</title>");
      out.println("</head>");

      out.println("<body>");
      out.println("   <h1>수업</h1>");
      out.println("   <a href='add'>새 수업</a>");
      out.println("   <table border='1'>");
      out.println("       <tr>");
      out.println("           <th>번호</th>");
      out.println("           <th>수업명</th>");
      out.println("           <th>수업일</th>");
      out.println("           <th>총수업시간</th>");
      out.println("       </tr>");

      for (Lesson l : lessons) {
        out.printf(
            "<tr><td>%d</td> <td><a href='detail?no=%d'>%s</a></td> <td>%s ~ %s</td> <td>%d</td></tr>\n",
            l.getNo(), l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(),
            l.getTotalHours());
      }
      out.println("    </table>");

      out.println("<hr>");

      out.println("<form action='search'>");
      out.println("강의명: <input name='title' type='text'><br>");
      out.println("강의 시작일: <input name='startDate' type='date'><br>");
      out.println("강의 종료일: <input name='endDate' type='date'><br>");
      out.println("총 강의시간: <input name='totalHours' type='number'><br>");
      out.println("일 강의시간: <input name='dayHours' type='number'><br>");
      out.println("<button>검색</button>");
      out.println("</form>");

      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
