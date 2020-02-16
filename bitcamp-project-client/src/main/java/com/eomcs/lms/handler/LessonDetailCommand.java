package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.proxy.LessonDaoProxy;
import com.eomcs.util.Prompt;

public class LessonDetailCommand implements Command {

  Prompt prompt;
  LessonDaoProxy lessonDao;

  public LessonDetailCommand(LessonDaoProxy lessonDao, Prompt prompt) {
    this.lessonDao = lessonDao;
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

      ResultSet rs = stmt.executeQuery("SELECT * FROM lms_lesson WHERE lesson_id = " + no + ";");

      while (rs.next()) {
        // System.out.printf("번호: %d\n", lesson.getNo());
        System.out.printf("수업명: %s\n", rs.getString("titl"));
        System.out.printf("설명: %s\n", rs.getString("conts"));
        System.out.printf("시작일: %s\n", rs.getString("sdt"));
        System.out.printf("종료일: %s\n", rs.getString("edt"));
        System.out.printf("총수업시간: %d\n", rs.getInt("tot_hr"));
        System.out.printf("일수업시간: %d\n", rs.getInt("day_hr"));
      }
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}


