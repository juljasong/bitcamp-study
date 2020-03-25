package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.RequestMapping;

@Component
public class LoginServlet {

  MemberService memberService;

  public LoginServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/auth/login")
  public void service(Map<String, String> params, PrintStream out) throws Exception {

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta http-equiv='refresh' content='2;url=/member/list'>");
    out.println("<title>로그인 결과</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>로그인 결과</h1>");
    out.println("</body>");
    out.println("</html>");

    String email = params.get("email");
    String password = params.get("password");

    Member member = memberService.login(email, password);

    if (member != null) {
      out.printf("<p>'%s'님 환영합니다.\n</p>", member.getName());
    } else {
      out.println("<p>사용자 정보가 유효하지 않습니다.</p>");
    }
  }

}
