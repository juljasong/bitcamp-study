// 던지는 예외 받기
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0471 {

  static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else if (i == 3)
      throw new IOException();
    else if (i < 0)
      throw new Error(); // 시스템 오류 가정
  }

  public static void main(String[] args) {
    try {
      // try 블록에서 예외가 발생할 수 있는 메서드를 호출한다.
      m(-1);
    } catch (Throwable e) {
      System.out.println("어플리케이션 예외 발생");
      // Throwable 변수로 선언하면 시스템 오류인 Error까지 받아 JVM에서 발생된 오류에 대해서도
      // 예외 처리 하는 문제 발생
      // 시스템 오류는 어플리케이션에서 처리 불가 -> 실무에서는 Exception과 그 하위 객체만 사용
    }
  }

}
