package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoFileDaoImpl implements PhotoFileDao {

  String jdbcUrl;
  String userName;
  String password;

  public PhotoFileDaoImpl(String jdbcUrl, String userName, String password) {
    this.jdbcUrl = jdbcUrl;
    this.userName = userName;
    this.password = password;
  }

  @Override
  public int insert(PhotoFile photoFile) throws Exception {

    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("insert into lms_photo_file(photo_id,file_path) values('"
          + photoFile.getBoardNo() + "', '" + photoFile.getFilepath() + "')");

      return result;
    }
  }

  @Override
  public List<PhotoFile> findAll(int boardNo) throws Exception {
    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select photo_file_id, photo_id, file_path"
            + " from lms_photo_file where photo_id=" + boardNo + " order by photo_id ASC")) {

      ArrayList<PhotoFile> list = new ArrayList<>();

      while (rs.next()) {
        // PhotoFile photoFile = new PhotoFile(rs.getInt("photo_file_id"),
        // rs.getString("file_path"), rs.getInt("photo_id"));
        // photoFile.setNo(rs.getInt("photo_file_id"));
        // photoFile.setBoardNo(rs.getInt("photo_id"));
        // photoFile.setFilepath(rs.getString("file_path"));
        list.add(new PhotoFile().setNo(rs.getInt("photo_file_id"))
            .setFilepath(rs.getString("file_path")).setBoardNo(rs.getInt("photo_id")));
      }
      return list;
    }
  }

  @Override
  public int deleteAll(int boardNo) throws Exception {
    try (
        Connection con =
            DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("DELETE FROM lms_photo_file WHERE photo_id=" + boardNo);

      return result;
    }
  }

}
