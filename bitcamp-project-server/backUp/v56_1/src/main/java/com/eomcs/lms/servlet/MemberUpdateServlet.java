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
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
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
      out.println("<meta charset='UTF-8'>");
      out.println("<title>회원정보 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>회원정보 변경 변경</h1>");

      Member member = memberService.get(no);
      if (member == null) {
        out.println("<p>해당 번호의 회원이 없습니다.</p>");
      } else {
        out.println("<form action='update' method='post'>");
        out.printf("번호: <input name='no' readonly type='text' value='%d'><br>\n", member.getNo());
        out.printf("이름:<input name='name' type='text' value='%s'><br>\n", member.getName());
        out.printf("이메일:<input name='email' type='text' value='%s'><br>\n", member.getEmail());
        out.printf("암호:<input name='password' type='text' value='%s'><br>\n", member.getPassword());
        out.printf("사진:<input name='photo' type='text' value='%s'><br>\n", member.getPhoto());
        out.printf("전화번호:<input name='tel' type='text' value='%s'><br>\n", member.getTel());
        out.printf("등록일:<input name='registeredDate' readonly type='text' value='%s'><br>\n",
            member.getRegisteredDate());
        out.println("<button>변경</button>");
        out.println("</form>");
      }
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
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();

      ServletContext servletContext = request.getServletContext();
      ApplicationContext iocContainer =
          (ApplicationContext) servletContext.getAttribute("iocContainer");

      MemberService memberService = iocContainer.getBean(MemberService.class);
      int no = Integer.parseInt(request.getParameter("no"));

      Member member = new Member();
      member.setNo(no);
      member.setName(request.getParameter("name"));
      member.setEmail(request.getParameter("email"));
      member.setPassword(request.getParameter("password"));
      member.setPhoto(request.getParameter("photo"));
      member.setTel(request.getParameter("tel"));
      member.setRegisteredDate(Date.valueOf(request.getParameter("registeredDate")));

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<meta http-equiv='refresh' content='2;url=list'>");
      out.println("<title>회원정보 변경</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>회원정보 변경 결과</h1>");

      if (memberService.update(member) > 0) {
        out.println("<p>회원 정보를 변경했습니다.</p>");
      } else {
        out.println("<p>회원 정보 변경에 실패했습니다.</p>");
      }
      out.println("</body>");
      out.println("</html>");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
