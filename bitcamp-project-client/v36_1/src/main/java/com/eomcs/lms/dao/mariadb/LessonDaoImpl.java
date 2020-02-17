package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDaoImpl implements LessonDao {

  @Override
  public int insert(Lesson lesson) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver"); // 프록시 로딩

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      int result = stmt
          .executeUpdate("INSERT INTO lms_lesson(sdt, edt, tot_hr, day_hr, titl, conts) VALUES ('"
              + lesson.getStartDate().toString() + "', '" + lesson.getEndDate().toString() + "', "
              + lesson.getTotalHours() + ", " + lesson.getDayHours() + ", '" + lesson.getTitle()
              + "', '" + lesson.getDescription() + "');");

      return result;
    }
  }

  @Override
  public List<Lesson> findAll() throws Exception {

    Class.forName("org.mariadb.jdbc.Driver"); // 프록시 로딩

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM lms_lesson")) {

      ArrayList<Lesson> list = new ArrayList<>();

      while (rs.next()) {
        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lesson_id"));
        lesson.setTitle(rs.getString("conts"));
        lesson.setStartDate(rs.getDate("sdt"));
        lesson.setEndDate(rs.getDate("edt"));
        lesson.setDayHours(rs.getInt("day_hr"));
        list.add(lesson);
      }
      return list;
    }
  }

  @Override
  public Lesson findByNo(int no) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver"); // 프록시 로딩

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs =
            stmt.executeQuery("SELECT * FROM lms_lesson WHERE lesson_id = " + no + ";")) {

      if (rs.next()) {
        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lesson_id"));
        lesson.setTitle(rs.getString("titl"));
        lesson.setDescription(rs.getString("conts"));
        lesson.setStartDate(rs.getDate("sdt"));
        lesson.setEndDate(rs.getDate("edt"));
        lesson.setTotalHours(rs.getInt("tot_hr"));
        lesson.setDayHours(rs.getInt("day_hr"));
        return lesson;
      } else {
        return null;
      }
    }
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver"); // 프록시 로딩

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("update lms_lesson set" //
          + " titl='" + lesson.getTitle() //
          + "', conts='" + lesson.getDescription() //
          + "', sdt='" + lesson.getStartDate() //
          + "', edt='" + lesson.getEndDate() //
          + "', tot_hr=" + lesson.getTotalHours() //
          + ", day_hr=" + lesson.getDayHours() //
          + " where lesson_id=" + lesson.getNo());
      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    Class.forName("org.mariadb.jdbc.Driver"); // 프록시 로딩

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("DELETE FROM lms_lesson WHERE lesson_id=" + no + ";");

      return result;
    }
  }

}
