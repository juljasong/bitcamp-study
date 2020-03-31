package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/lesson/addForm")
public class LessonAddFormServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    try {

      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>수업 등록</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>수업 등록</h1>");
      out.println("<form action='add'>");
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
}
