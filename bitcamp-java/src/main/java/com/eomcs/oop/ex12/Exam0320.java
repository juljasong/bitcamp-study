// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0320 {

  static interface Calc {
    int compute(int a, int b);
  }

  static void test(Calc calc) {
    System.out.printf("결과: %d\n", calc.compute(200, 100));
  }

  public static void main(String[] args) {

    test((a, b) -> a + b);
    test((a, b) -> a * b);
  }
}


