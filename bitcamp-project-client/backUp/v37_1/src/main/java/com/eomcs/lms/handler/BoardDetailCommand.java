package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.util.Prompt;

// "/board/detail" 명령 처리
public class BoardDetailCommand implements Command {

  Prompt prompt;
  BoardDao boardDao;

  public BoardDetailCommand(BoardDao boardDao, Prompt prompt) {
    this.boardDao = boardDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int no = prompt.inputInt("번호? ");

      Class.forName("org.mariadb.jdbc.Driver");

      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      // PreparedStatement pstm = con.prepareStatement("SELECT * FROM lms_board WHERE board_id = ?
      // ;");
      // pstm.setInt(1, no);
      // ResultSet rs = pstm.executeQuery();

      Statement stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("SELECT * FROM lms_board WHERE board_id = " + no + ";");

      while (rs.next()) {
        System.out.printf("제목: %s\n", rs.getString("conts"));
        System.out.printf("등록일: %s\n", rs.getString("cdt"));
        System.out.printf("조회수: %d\n", rs.getInt("vw_cnt"));
      }

    } catch (Exception e) {
      System.out.println("조회 실패!");
    }
  }
}


