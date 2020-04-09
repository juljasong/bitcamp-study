package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/add")
public class LessonAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {

      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>수업 등록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>수업 등록</h1>");
      out.println("<form action='add' method='post'>");
      out.println("수업명: <input name='title' type='text'><br>\n");
      out.println("수업내용:<br>");
      out.println("<textarea name='description' rows='5' cols='60'></textarea><br>");
      out.println("시작일: <input name='startDate' type='text'><br>\n");
      out.println("종료일: <input name='endDate' type='text'><br>\n");
      out.println("총수업시간: <input name='totalHours' type='text'><br>\n");
      out.println("일수업시간: <input name='dayHours' type='text'><br>\n");
      out.println("<button>제출</button>");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      request.setCharacterEncoding("UTF-8");

      ServletContext servletContext = request.getServletContext();
      ApplicationContext iocContainer =
          (ApplicationContext) servletContext.getAttribute("iocContainer");

      LessonService lessonService = iocContainer.getBean(LessonService.class);

      Lesson lesson = new Lesson();
      lesson.setTitle(request.getParameter("title"));
      lesson.setDescription(request.getParameter("description"));
      lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
      lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
      lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
      lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));
      if (lessonService.insert(lesson) > 0) {
        response.sendRedirect("list");
      } else {
        request.getSession().setAttribute("errorMessage", "강의 추가 실패.");
        request.getSession().setAttribute("url", "lesson/list");
        response.sendRedirect("../error");
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
