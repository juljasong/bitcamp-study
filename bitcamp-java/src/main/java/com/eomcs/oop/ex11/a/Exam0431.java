// anonymous class - 람다 사용
package com.eomcs.oop.ex11.a;

public class Exam0431 {

  static abstract class A {
    public abstract void print();
  }

  public static void main(final String[] args) {

    // 클래스에 대해서는 람다 사용이 불가능하다

    final A obj = () -> System.out.println("Hello2!");

    obj.print();

  }
}
