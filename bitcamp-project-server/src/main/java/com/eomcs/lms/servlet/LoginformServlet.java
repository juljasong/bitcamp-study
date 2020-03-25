package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class LoginformServlet {

  MemberService memberService;

  public LoginformServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/auth/loginform")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>로그인</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>로그인</h1>");
    out.println("<form action='/auth/login'>");
    out.println("email: <input name='email' type='type'><br>\n");
    out.println("password: <input name='password' type='text'><br>\n");
    out.println("<button>로그인</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");

  }

}
