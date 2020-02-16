package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.proxy.MemberDaoProxy;

public class MemberListCommand implements Command {

  MemberDaoProxy memberDao;

  public MemberListCommand(MemberDaoProxy memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    try {
      Class.forName("org.mariadb.jdbc.Driver");

      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("SELECT * FROM lms_member");

      while (rs.next()) {
        System.out.printf("%d, %s, %s, %s, %s\n", rs.getInt("member_id"), rs.getString("name"),
            rs.getString("email"), rs.getString("tel"), rs.getString("cdt"));
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}
