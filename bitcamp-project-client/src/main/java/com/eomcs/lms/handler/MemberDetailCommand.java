package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.proxy.MemberDaoProxy;
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

      Class.forName("org.mariadb.jdbc.Driver");

      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("SELECT * FROM lms_member WHERE member_id = " + no + ";");

      while (rs.next()) {
        // System.out.printf("번호: %d\n", member.getNo());
        System.out.printf("이름: %s\n", rs.getString("name"));
        System.out.printf("이메일: %s\n", rs.getString("email"));
        System.out.printf("암호: %s\n", rs.getString("pwd"));
        System.out.printf("사진: %s\n", rs.getString("photo"));
        System.out.printf("전화: %s\n", rs.getString("tel"));
      }

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
