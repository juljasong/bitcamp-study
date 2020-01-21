// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0331 {

  static interface Calc {
    int compute(int a, int b);
  }

  static void test(Calc calc) {
    System.out.printf("결과: %d\n", calc.compute(1, 10));
  }

  public static void main(String[] args) {

    test(new Calc() {
      @Override
      public int compute(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
          sum += i;
        }
        return sum;
      }
    });
  }
}


