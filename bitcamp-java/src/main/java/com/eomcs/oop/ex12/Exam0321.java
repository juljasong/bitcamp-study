// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0321 {

  static interface Calc {
    int compute(int start, int end);
  }

  static void test(Calc calc) {
    System.out.printf("결과 : %d\n", calc.compute(1, 10));
  }


  public static void main(String[] args) {

    test(new Calc() {
      @Override
      public int compute(int a, int b) {
        return a + b;
      }
    });
    test(new Calc() {
      @Override
      public int compute(int a, int b) {
        return a * b;
      }
    });
  }
}


