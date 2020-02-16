package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.proxy.LessonDaoProxy;

public class LessonListCommand implements Command {

  LessonDaoProxy lessonDao;

  public LessonListCommand(LessonDaoProxy lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    try {
      Class.forName("org.mariadb.jdbc.Driver");

      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select * from lms_lesson");

      while (rs.next()) {
        System.out.printf("%d, %s, %s ~ %s, %d\n", rs.getInt("lesson_id"), rs.getString("titl"),
            rs.getString("sdt"), rs.getString("edt"), rs.getInt("day_hr"));
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}


