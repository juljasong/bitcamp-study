package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.service.MemberService;
import com.eomcs.util.Prompt;

public class MemberDeleteServlet implements Servlet {

  MemberService memberService;

  public MemberDeleteServlet(MemberService memberService) {
    this.memberService = memberService;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int no = Prompt.getInt(in, out, "번호? ");

    if (memberService.delete(no) > 0) {
      out.println("회원을 삭제하였습니다.");

    } else {
      out.println("회원 삭제에 실패하였습니다.");
    }
  }
}
