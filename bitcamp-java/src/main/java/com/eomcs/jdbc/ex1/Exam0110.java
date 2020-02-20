// JDBC 드라이버 준비 - 드라이버 다운로드 및 로딩
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Exam0110 {

  public static void main(String[] args) {

    try {
      DriverManager.registerDriver(new org.mariadb.jdbc.Driver());

      java.sql.Driver driver = DriverManager.getDriver("jdbc:oracle:"); // Error : No suitable
                                                                        // driver => 해당 db driver X
      System.out.println("JDBC 드라이버 로딩 및 등록 완료!");

    } catch (SQLException e) {
      System.out.println("MariaDB의 java.sql.Driver 구현체를 등록하는 중에 오류 발생!");
      e.printStackTrace();
    }
  }
}
