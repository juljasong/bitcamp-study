package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/update")
public class LessonUpdateServlet extends GenericServlet {
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

      int no = Integer.parseInt(req.getParameter("no"));
      Lesson lesson = new Lesson();

      lesson.setNo(no);
      lesson.setTitle(req.getParameter("title"));
      lesson.setDescription(req.getParameter("description"));
      lesson.setStartDate(Date.valueOf(req.getParameter("startDate")));
      lesson.setEndDate(Date.valueOf(req.getParameter("endDate")));
      lesson.setTotalHours(Integer.parseInt(req.getParameter("totalHours")));
      lesson.setDayHours(Integer.parseInt(req.getParameter("dayHours")));

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta http-equiv='refresh' content='2;url=list'>");
      out.println("<title>수업 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>수업 변경 결과</h1>");

      if (lessonService.update(lesson) > 0) {
        out.println("<p>수업 정보를 변경했습니다.</p>");
      } else {
        out.println("<p>수업 변경에 실패했습니다.</p>");
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
