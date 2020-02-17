package com.eomcs.lms.handler;

import com.eomcs.lms.dao.proxy.MemberDaoProxy;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberDetailCommand implements Command {

  Prompt prompt;
  MemberDaoProxy memberDao;

  public MemberDetailCommand(MemberDaoProxy memberDao, Prompt prompt) {
    this.memberDao = memberDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");

      Member member = memberDao.findByNo(no);

      System.out.printf("이름: %s\n", member.getName());
      System.out.printf("이메일: %s\n", member.getEmail());
      System.out.printf("암호: %s\n", member.getPassword());
      System.out.printf("사진: %s\n", member.getPhoto());
      System.out.printf("전화: %s\n", member.getTel());

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
