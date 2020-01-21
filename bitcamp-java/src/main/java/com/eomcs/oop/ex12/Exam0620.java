// 인스턴스 메서드 레퍼런스
package com.eomcs.oop.ex12;

public class Exam0620 {

  static class Calculator {
    double rate;

    public Calculator(double rate) {
      this.rate = rate;
    }


    public double year(int money) {
      return money * rate / 100;
    }

    public double month(int money) {
      return money * rate / 100 / 12;
    }

    public double day(int money) {
      return money * rate / 100 / 365;
    }

    static interface Interest {
      double compute(int money);
    }

    public static void main(String[] args) {

      Calculator 보통예금 = new Calculator(0.5);
      Calculator 정기예금 = new Calculator(1.5);
      Calculator 청년행복예금 = new Calculator(10);

      Interest i1 = new Interest() {
        @Override
        public double compute(int money) {

        }
      };
  }
}


