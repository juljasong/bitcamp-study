package com.eomcs.lms.servlet;

import java.io.PrintStream;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateServlet implements Servlet {

  MemberDao memberDao;

  public MemberUpdateServlet(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? \n!{}!");
    int no = Integer.parseInt(in.nextLine());
    out.flush();

    Member old = memberDao.findByNo(no);

    if (old == null) {
      out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    Member member = new Member();

    member.setNo(no);

    out.printf("이름(%s)? \n!{}!\n", old.getName());
    out.flush();
    member.setName(in.nextLine());

    out.printf("이메일(%s)? \n!{}!\n", old.getEmail());
    out.flush();
    member.setEmail(in.nextLine());

    out.printf("암호(%s)? \n!{}!\n", old.getPassword());
    out.flush();
    member.setPassword(in.nextLine());

    out.printf("사진(%s)? \n!{}!\n", old.getPhoto());
    out.flush();
    member.setPhoto(in.nextLine());

    out.printf("전화(%s)? \n!{}!\n", old.getTel());
    out.flush();
    member.setTel(in.nextLine());

    if (memberDao.update(member) > 0) {
      out.println("회원 정보를 변경했습니다.");
    } else {
      out.println("회원 정보 변경에 실패했습니다.");
    }
  }
}
