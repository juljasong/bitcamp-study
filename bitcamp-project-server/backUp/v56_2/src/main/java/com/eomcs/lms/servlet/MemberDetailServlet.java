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
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {
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

      MemberService memberService = iocContainer.getBean(MemberService.class);
      int no = Integer.parseInt(request.getParameter("no"));

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("   <meta charset='UTF-8'>");
      out.println("   <title>회원 상세정보</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>회원 상세정보</h1>");
      Member member = memberService.get(no);
      if (member != null) {
        out.printf("이름: %s\n<br>", member.getName());
        out.printf("이메일: %s\n<br>", member.getEmail());
        out.printf("암호: %s\n<br>", member.getPassword());
        out.printf("사진: %s\n<br>", member.getPhoto());
        out.printf("전화: %s\n<br>", member.getTel());
        out.printf("<p><a href='delete?no=%d'>삭제</a>\n", member.getNo());
        out.printf("<a href='update?no=%d'>변경</a></p>\n", member.getNo());
      } else {
        out.println("<p>해당 번호의 회원이 없습니다.</p>");
      }
      out.println("</body>");
      out.println("</html>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
