// 메서드 레퍼런스 - static
package com.eomcs.oop.ex12;

public class Exam0511 {

  static class MyCalculator {
    public static int plus(int a, int b) { return a + b; }
    public static int minus(int a, int b) { return a - b; }
    public static int multiple(int a, int b) { return a * b; }
    public static int divide(int a, int b) { return a / b; }
  }

  static interface Calculator1 {
    double compute(int a, int b);
  }
  static interface Calculator2 {
    float compute(int a, int b);
  }
  static interface Calculator3 {
    short compute(int a, int b);
  }
  static interface Calculator4 {
    void compute(int a, int b);
  }
  static interface Calculator5 {
    Object compute(int a, int b);
  }
  static interface Calculator6 {
    String compute(int a, int b);
  }

  public static void main(String[] args) {
    // 리턴타입 int ===> double (OK)
    Calculator1 c1 = MyCalculator::plus;
    System.out.println(c1.compute(100, 200));

    // 리턴타입 int ===> float (OK)
    Calculator2 c2 = MyCalculator::plus;
    System.out.println(c2.compute(100, 200));

    // 리턴타입 int ===> short (X)
    //Calculator3 c3 = MyCalculator::plus;

    // 리턴타입 int ===> void (OK)
    Calculator4 c4 = MyCalculator::plus;
    c4.compute(100, 200);

    // 리턴타입 int ===> Object (OK)
    Calculator5 c5 = MyCalculator::plus;
    System.out.println(c5.compute(100, 200));

    // 리턴타입 int ===> String (X)
    //Calculator6 c6 = MyCalculator::plus;

    /*
     * 메서드 레퍼런스의 리턴 타입 규칙
     * 1) 같은 리턴 타입
     * 2) void
     * 3) 암시적 형변환 가능한 타입
     * 4) auto-boxing 가능
     */

  }
}


