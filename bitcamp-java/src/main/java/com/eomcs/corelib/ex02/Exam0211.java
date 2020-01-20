// Wrapper 클래스 - 종류
package com.eomcs.corelib.ex02;

public class Exam0211 {
  public static void main(String[] args) {

    // new 명령을 사용하면 주도건 새 인스턴스를 만드는 것이다.

    Integer i = new Integer(3000000);
    Integer i2 = new Integer(3000000);
    System.out.println(i == i2); // false

    Integer x1 = 100;
    Integer x2 = 100;
    System.out.println(x1 == x2); // true

    // -128 ~ 127 범위의 수는 Integer 객체를 만들면 내부 메모리(cache)에 보관한다.
    // 같은 값의 객체가 여러 개 생성되지 않음.

    Integer i3 = Integer.valueOf(127);
    Integer i4 = Integer.valueOf(127);
    System.out.println(i3 == i4); // true

    Integer i5 = Integer.valueOf(128);
    Integer i6 = Integer.valueOf(128);
    System.out.println(i5 == i6); // false

  }
}


