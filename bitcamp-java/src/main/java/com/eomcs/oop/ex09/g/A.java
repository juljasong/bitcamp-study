package com.eomcs.oop.ex09.g;

public interface A {

  /* public abstract */ void m1();

  default void m2() {} // 구현된 default 메서드는 인터페이스에 둘 수 있다.

  static void m3() {
    System.out.println("인터페이스도 static 둘 수 있음");
  }

}
