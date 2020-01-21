// 메서드 레퍼런스 - static
package com.eomcs.oop.ex12;

public class Exam0510 {

  static class MyCalculator {
    public static int plus(int a, int b) {
      return a + b;
    }

    public static int minus(int a, int b) {
      return a - b;
    }

    public static int multiple(int a, int b) {
      return a * b;
    }

    public static int divide(int a, int b) {
      return a / b;
    }
  }

  static interface Calculater {
    double compute(int a, int b);
  }

  public static void main(String[] args) {
    // 메서드 한 개짜리 인터페이스 구현체를 만들 때,
    // 기존 스태틱 메서드를 람다 구현체로 사용 가능
    // => 인터페이스에 선언된 메서드의 규격(파라미터 타입 및 개수, 리턴 타입)과 일치해야 함
    Calculater c1 = MyCalculator::plus;
    Calculater c2 = MyCalculator::minus;
    Calculater c3 = MyCalculator::multiple;
    Calculater c4 = MyCalculator::divide;

    System.out.println(c1.compute(200, 17));
    System.out.println(c2.compute(200, 17));
    System.out.println(c3.compute(200, 17));
    System.out.println(c4.compute(200, 17));

  }
}


