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

@WebServlet("/lesson/detail")
public class LessonDetailServlet extends GenericServlet {
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
        out.printf("<a href='updateForm?no=%d'>변경</a>\n", lesson.getNo());
        out.printf("<a href='../photoBoard/list?no=%d'>사진 게시판</a></p>\n", lesson.getNo());
      } else {
        out.println("해당 번호의 수업이 없습니다.");
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
