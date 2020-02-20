// 게시물 관리 - 조회
package com.eomcs.jdbc.ex2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 다음과 같이 게시물을 조회하는 프로그램을 작성하라!
// ----------------------------
// 번호? 1
// 제목: aaa
// 내용: aaaaa
// 등록일: 2019-1-1
// 조회수: 2
//
// 번호? 100
// 해당 번호의 게시물이 존재하지 않습니다.
// ----------------------------
public class Exam0130 {

  public static void main(String[] args) throws Exception {
    int index = -1;
    try (Scanner sc = new Scanner(System.in)) {
      System.out.print("번호? ");
      index = sc.nextInt();
    }

    try (
        Connection con = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM x_board WHERE board_id=" + index)) {

      if (index == -1) {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        return;
      }

      while (rs.next()) {
        System.out.printf("제목: %s\n", rs.getString("title"));
        System.out.printf("내용: %s\n", rs.getString("contents"));
        System.out.printf("등록일: %s\n", rs.getDate("created_date"));
        System.out.printf("조회수: %d\n", rs.getInt("view_count"));
      }
    }
  }
}


