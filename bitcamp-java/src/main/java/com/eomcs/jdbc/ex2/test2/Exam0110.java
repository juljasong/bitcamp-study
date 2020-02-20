// 게시판 관리 - 등록
package com.eomcs.jdbc.ex2.test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// 다음과 같이 게시물을 등록하는 프로그램을 작성하라!
// ----------------------------
// 제목? aaa
// 내용? bbb
// 등록하시겠습니까?(Y/n) y
// 등록하였습니다.
// 등록하시겠습니까?(Y/n) n
// 등록을 취소 하였습니다.
// ----------------------------
public class Exam0110 {

  public static void main(String[] args) throws Exception {

    Scanner sc = new Scanner(System.in);

    System.out.print("제목? ");
    String title = sc.nextLine();
    System.out.print("내용? ");
    String content = sc.nextLine();
    System.out.print("등록하시겠습니까?(Y/n) ");
    String input = sc.nextLine();

    if (!input.equalsIgnoreCase("Y") && input.length() != 0) {
      System.out.println("등록을 취소하였습니다.");
    } else {
      try (Connection con = DriverManager.getConnection( //
          "jdbc:mysql://localhost:3306/studydb?user=study&password=1111");
          PreparedStatement stmt =
              con.prepareStatement("INSERT INTO x_board(title, contents) VALUES(?, ?)")) {
        stmt.setString(1, title);
        stmt.setString(2, content);
        stmt.executeUpdate();
      }
    }
    sc.close();
  }
}


