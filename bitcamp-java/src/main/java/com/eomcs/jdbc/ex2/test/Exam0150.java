// 게시판 관리 - 삭제
package com.eomcs.jdbc.ex2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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


    int index = -1;


    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("번호? ");
      index = sc.nextInt();
    }

    if (index == -1) {
      System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      return;
    }

    try (Connection con = DriverManager.getConnection( //
        "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();) {
      stmt.executeUpdate(String.format("DELETE FROM x_board WHERE board_id = %d", index));
      System.out.println("삭제하였습니다.");
    }

  }
}


