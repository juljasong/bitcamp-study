// JDBC 드라이버 준비 - DriverManager가 Driver 구현체를 자동 로딩
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam0140 {

  public static void main(String[] args) {
    System.out.printf("java.home=%s\n", System.getProperty("java.home"));
    System.out.printf("user.home=%s\n", System.getProperty("user.home"));

    // 시스템 프로퍼티 설정 방법
    // => java -Djdbc.drivers=클래스명:클래스명:클래스명
    System.setProperty("jdbc.drivers", "com.eomcs.jdbc.ex1.MyDriver:org.mariadb.jdbc.Driver");
    System.out.printf("jdbc.drivers=%s\n", System.getProperty("jdbc.drivers"));
    // JDBC 드라이버 로딩 방법4: Driver 구현체 자동 로딩
    // => DriverManager를 사용할 때,
    // DriverManager 는 다음 절차에 따라 Driver 구현체를 자동 로딩한다.
    //
    // 1) jdbc.drivers 시스템 프로퍼티에 지정된 구현체를 찾아 로딩한다.
    // => jdbc.drivers=foo.bah.Driver:wombat.sql.Driver:bad.taste.ourDriver
    // => 이때 각 Driver 구현체는 'system class loader'를 통해 로딩된다.


    try {

      // DriverManager에 자동 등록된 것을 확인해보자!
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
      System.out.println(driver);

    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
  }
}


