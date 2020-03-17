// Reflection API : 클래스 로딩과 레퍼런스
package com.eomcs.reflect.ex01;

public class Exam02 {

  static {
    System.out.println("Exam02 로딩됨!");
  }

  static class A {
    static int s_var = 100;
    int i_var = 200;

    static void s_m() {}

    void i_m() {}

    static {
      System.out.println("Exam02 중첩 클래스 A 로딩!");
    }
  }

  public static void main(String[] args) throws Exception {
    Class clazz = Class.forName("com.eomcs.reflect.ex01.Exam02");
    // 바깥 클래스가 로딩되었다고 중첩 클래스가 자동으로 로딩되는 것은 아님.
    // 중첩 클래스는 단지 클래스에 소속된다는 것.
    // 중첩 클래스는 "클래스명$중첩클래스명" 형식의 이름을 갖는다.

    // Class clazz = Class.forName("com.eomcs.reflect.ex01.Exam02$A");
    // Class clazz = Class.forName("com.eomcs.reflect.ex01.Exam02$A");
    // 중첩로딩다메~
  }

}


