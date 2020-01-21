// 람다(lambda) - 리턴 값 있는 경우
package com.eomcs.oop.ex12;

public class Exam0150 {

  static interface Calc {
    int compute(int a, int b);
  }

  public static void main(String[] args) {

    Calc cal = (a, b) -> {
      return a + b;
    };

    // return 생략 가능 -> return 값 있는 경우 반드시 표현식(expression)이 와야함.
    // 표현식 : 실행 후 결과가 리턴되는 명령
    Calc cal2 = (a, b) -> a + b;

    // 이건 안됨.
    /*
     * Calc cal3 = (a, b) -> return a + b;
     */

    System.out.println(cal.compute(4, 6));

    System.out.println(cal2.compute(40, 60));

  }

}


