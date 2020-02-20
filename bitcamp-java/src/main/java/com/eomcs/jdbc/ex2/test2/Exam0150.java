// 게시판 관리 - 삭제
package com.eomcs.jdbc.ex2.test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// 다음과 같이 게시물을 삭제하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 삭제하였습니다.
// (또는)
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0150 {

  public static void main(String[] args) throws Exception {
    int no = -1;

    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.print("번호? ");
      no = keyScan.nextInt();
    }

    try (Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement("delete from x_board where board_id = ?")) {

      stmt.setInt(1, no);

      int count = stmt.executeUpdate();

      if (count == 0) {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      } else {
        System.out.println("삭제하였습니다.");
      }
    }
  }
}


