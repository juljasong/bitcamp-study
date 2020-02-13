package com.eomcs.lms.handler;

import com.eomcs.lms.dao.proxy.MemberDaoProxy;
import com.eomcs.util.Prompt;

public class MemberDeleteCommand implements Command {

  Prompt prompt;
  MemberDaoProxy memberDao;

  public MemberDeleteCommand(MemberDaoProxy memberDao, Prompt prompt) {
    this.memberDao = memberDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");

      memberDao.delete(no);
      System.out.println("회원을 삭제했습니다.");

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
