package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/updateForm")
public class LessonUpdateFormServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    try {

      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();

      ServletContext servletContext = req.getServletContext();
      ApplicationContext iocContainer =
          (ApplicationContext) servletContext.getAttribute("iocContainer");

      LessonService lessonService = iocContainer.getBean(LessonService.class);

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>수업 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>수업 변경</h1>");

      int no = Integer.parseInt(req.getParameter("no"));
      Lesson lesson = lessonService.get(no);

      if (lesson == null) {
        out.println("<p>해당 번호의 게시글이 없습니다.</p>");
      } else {
        out.println("<form action='update'>");
        out.printf("번호: <input name='no' readonly type='text' value='%d'><br>\n", lesson.getNo());
        out.printf("수업명: <input name='title' type='text' value='%s'><br>\n", lesson.getTitle());
        out.println("내용:<br>");
        out.printf("<textarea name='description' rows='5' cols='60'>%s</textarea><br>",
            lesson.getDescription());
        out.printf("시작일: <input name='startDate' type='text' value='%s'><br>\n",
            lesson.getStartDate());
        out.printf("종료일: <input name='endDate' type='text' value='%s'><br>\n", lesson.getEndDate());
        out.printf("일수업시간: <input name='dayHours' type='text' value='%d'><br>\n",
            lesson.getDayHours());
        out.printf("총수업시간: <input name='totalHours' type='text' value='%d'><br>\n",
            lesson.getTotalHours());
        out.println("<button>변경</button>");
        out.println("</form>");
      }
      out.println("</body>");
      out.println("</html>");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
