package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao {

  Connection con;

  public PhotoBoardDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public int insert(PhotoBoard photoBoard) throws Exception {

    try (Statement stmt = con.createStatement()) {

      con.setAutoCommit(true);

      int result = stmt.executeUpdate("insert into lms_photo(titl,lesson_id) values('"
          + photoBoard.getTitle() + "', " + photoBoard.getLesson().getNo() + ")",
          Statement.RETURN_GENERATED_KEYS); // insert 후 PK 값 리턴

      try (ResultSet generatedKeySet = stmt.getGeneratedKeys()) {
        generatedKeySet.next(); // PK 컬럼의 값을 가져옴
        photoBoard.setNo(generatedKeySet.getInt(1)); // PK 컬럼의 값을 꺼냄
      }

      return result;
    }
  }

  @Override
  public List<PhotoBoard> findAllByLessonNo(int lesson_id) throws Exception {

    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select photo_id, titl, cdt, vw_cnt, lesson_id"
            + " from lms_photo" + " where lesson_id=" + lesson_id + " order by photo_id desc")) {

      ArrayList<PhotoBoard> list = new ArrayList<>();

      while (rs.next()) {
        PhotoBoard photoBoard = new PhotoBoard();
        photoBoard.setNo(rs.getInt("photo_id"));
        photoBoard.setTitle(rs.getString("titl"));
        photoBoard.setCreatedDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));
        list.add(photoBoard);
      }
      return list;
    }
  }

  @Override
  public PhotoBoard findByNo(int no) throws Exception {

    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select p.photo_id, p.titl, p.cdt, p.vw_cnt, l.lesson_id, l.titl lesson_title"
                + " from lms_photo p inner join lms_lesson l" + " on p.lesson_id = l.lesson_id"
                + " where photo_id = " + no)) {

      if (rs.next()) {
        PhotoBoard photoBoard = new PhotoBoard();
        photoBoard.setNo(rs.getInt("photo_id"));
        photoBoard.setTitle(rs.getString("titl"));
        photoBoard.setCreatedDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));

        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lesson_id"));
        lesson.setTitle(rs.getString("lesson_title"));

        photoBoard.setLesson(lesson);

        return photoBoard;
      } else {
        return null;
      }
    }
  }

  @Override
  public int update(PhotoBoard photoBoard) throws Exception {

    try (Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("UPDATE lms_photo SET titl='" + photoBoard.getTitle()
          + "' WHERE photo_id=" + photoBoard.getNo());
      // .executeUpdate()의 리턴값은 서버에 입력된 데이터의 개수

      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {

    try (Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("DELETE FROM lms_photo WHERE photo_id=" + no);

      return result;
    }
  }

}
