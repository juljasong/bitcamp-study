package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.eomcs.lms.dao.proxy.BoardDaoProxy;

// "/board/list" 명령어 처리
public class BoardListCommand implements Command {

  BoardDaoProxy boardDao;

  public BoardListCommand(BoardDaoProxy boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    try {
      // List<Board> boards = boardDao.findAll();

      // JDBC Driver (MariaDB 프록시) 로딩
      Class.forName("org.mariadb.jdbc.Driver");

      // JDBC Driver 이용하여 MariaDB 접속
      Connection con =
          DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      // MariaDB에 명령을 전달할 객체 준비
      Statement stmt = con.createStatement();

      // MariaDB의 lms_board 테이블 데이터 가져올 준비
      ResultSet rs = stmt.executeQuery("select board_id, conts, cdt, vw_cnt from lms_board");
      // ResultSet rs = stmt.executeQuery("select * from lms_board");
      // ResultSet 도구를 사용해 데이터를 하나씩 가져옴

      while (rs.next()) {
        System.out.printf("%d, %s, %s, %d\n", rs.getInt("board_id"), rs.getString("conts"),
            rs.getDate("cdt"), rs.getInt("vw_cnt"));
      }

      rs.close();
      stmt.close();
      con.close();
      /*
       * for (Board b : boards) { System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(),
       * b.getDate(), b.getViewCount()); }
       */
    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }

}


