// 게시물 관리 - 목록
package com.eomcs.jdbc.ex2.test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 다음과 같이 게시물 목록을 출력하라!
// 게시물 번호를 내림차순으로 정렬하라.
// ----------------------------
// 번호, 제목, 등록일, 조회수
// 2, aaa, 2019-1-1, 2
// 1, bbb, 2018-12-31, 3
// ----------------------------
public class Exam0120 {

  public static void main(String[] args) throws Exception {
    try (Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt =
            con.prepareStatement("select * from x_board order by board_id desc");
        ResultSet rs = stmt.executeQuery()) {

      System.out.println("번호, 제목, 등록일, 조회수");
      while (rs.next()) {

        System.out.printf("%d, %s, %s, %s, %d\n", //
            rs.getInt("board_id"), //
            rs.getString("title"), //
            rs.getString("contents"), //
            rs.getDate("created_date"), //
            rs.getInt("view_count"));
      }
    }
  }
}


