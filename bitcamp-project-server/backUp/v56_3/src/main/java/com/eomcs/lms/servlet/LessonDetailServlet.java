package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@WebServlet("/lesson/detail")
public class LessonDetailServlet extends HttpServlet {
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
      int no = Integer.parseInt(request.getParameter("no"));

      Lesson lesson = lessonService.get(no);

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>수업 상세정보</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>수업 상세정보</h1>");

      if (lesson != null) {
        out.printf("수업명: %s<br>\n", lesson.getTitle());
        out.printf("설명: %s<br>\n", lesson.getDescription());
        out.printf("시작일: %s<br>\n", lesson.getStartDate());
        out.printf("종료일: %s<br>\n", lesson.getEndDate());
        out.printf("일수업시간: %d<br>\n", lesson.getDayHours());
        out.printf("총수업시간: %d<br>\n", lesson.getTotalHours());
        out.printf("<p><a href='delete?no=%d'>삭제</a>\n", lesson.getNo());
        out.printf("<a href='update?no=%d'>변경</a>\n", lesson.getNo());
        out.printf("<a href='../photoBoard/list?no=%d'>사진 게시판</a></p>\n", lesson.getNo());
      } else {
        request.getSession().setAttribute("errorMessage", "해당 번호의 강의가 없습니다.");
        request.getSession().setAttribute("url", "lesson/list");
        response.sendRedirect("../error");
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
