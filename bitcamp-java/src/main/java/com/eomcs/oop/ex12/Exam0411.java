// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0411 {

  static interface Interest {
    double compute(int money);
  }

  static Interest getInterest(final double rate) {
    class MyInterest implements Interest {

      @Override
      public double compute(int money) {
        return money + (money * rate / 100);
      }
    }

    return new MyInterest();
  }

  public static void main(String[] args) {
    Interest i1 = getInterest(1.5);
    System.out.printf("합계:%.1f\n", i1.compute(10_0000_0000));

  }
}


