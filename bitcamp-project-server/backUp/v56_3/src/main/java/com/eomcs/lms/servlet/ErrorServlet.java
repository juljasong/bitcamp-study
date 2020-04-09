package com.eomcs.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>Error!</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>Error!</h1>");
    out.printf("<h3>%s</h3>", request.getSession().getAttribute("errorMessage"));
    String url = (String) request.getSession().getAttribute("url");
    out.printf("<p><a href='%s'>뒤로 가기</a></p>", url);
    out.println("</body>");
    out.println("</html>");
  }
}
