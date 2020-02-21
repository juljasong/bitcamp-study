package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl implements BoardDao {

  Connection con;

  public BoardDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public int insert(Board board) throws Exception {


    try (Statement stmt = con.createStatement()) {

      con.setAutoCommit(true);

      int result =
          stmt.executeUpdate("INSERT INTO lms_board(conts) VALUES ('" + board.getTitle() + "');");
      // .executeUpdate()의 리턴값은 서버에 입력된 데이터의 개수

      return result;
    }
  }

  @Override
  public List<Board> findAll() throws Exception {

    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select board_id, conts, cdt, vw_cnt from lms_board")) {

      ArrayList<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_id"));
        board.setTitle(rs.getString("conts"));
        board.setDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));
        list.add(board);
      }
      return list;
    }
  }

  @Override
  public Board findByNo(int no) throws Exception {

    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select board_id, conts, cdt, vw_cnt from lms_board where board_id = " + no)) {

      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("board_id"));
        board.setTitle(rs.getString("conts"));
        board.setDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("vw_cnt"));
        return board;
      } else {
        return null;
      }
    }
  }

  @Override
  public int update(Board board) throws Exception {

    try (Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate(
          "UPDATE lms_board SET conts='" + board.getTitle() + "' WHERE board_id=" + board.getNo());
      // .executeUpdate()의 리턴값은 서버에 입력된 데이터의 개수

      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {

    try (Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("DELETE FROM lms_board WHERE board_id=" + no);

      return result;
    }
  }

}
