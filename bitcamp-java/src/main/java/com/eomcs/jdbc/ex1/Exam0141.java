// JDBC 드라이버 준비 - DriverManager가 Driver 구현체를 자동 로딩
package com.eomcs.jdbc.ex1;

public class Exam0141 {

  public static void main(String[] args) {

    // 2) java.sql.Driver 클래스의 서비스 제공자를 찾아 로딩한다.
    // => jar 파일 안에 META-INF/services/java.sql.Driver 파일을 찾는다.
    // => 이때 'service-provider loading' 절차에 따라 이 파일에 등록된 클래스를 로딩한다.
    // => jar 파일에 해당 정보가 있다면,
    // 앞의 예제처럼 개발자가 따로 java.sql.Driver 구현체를 명시적으로 등록하지 않아도 된다.
    // => mariadb JDBC 드라이버 jar 파일은 이 정보가 들어 있다.
    // 따라서 java.sql.Driver를 구현한 클래스를 로딩하거나 생성할 필요가 없다.

    try {
      // Driver 구현체 명시적 로딩 X
      // 'service-provider loading' 절차에 따라 mariadb의 Driver 구현체가 로딩되고 객체가 생성되어 등록될 것.

      // DriverManager에 자동 등록된 것을 확인해보자!
      // java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
      // System.out.println(driver);

    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류 발생!");
      e.printStackTrace();
    }
  }
}


