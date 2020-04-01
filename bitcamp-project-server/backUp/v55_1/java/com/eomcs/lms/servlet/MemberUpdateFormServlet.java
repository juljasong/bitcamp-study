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
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@WebServlet("/member/updateForm")
public class MemberUpdateFormServlet extends GenericServlet {
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

      MemberService memberService = iocContainer.getBean(MemberService.class);

      int no = Integer.parseInt(req.getParameter("no"));

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
        out.println("<form action='update'>");
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
}
