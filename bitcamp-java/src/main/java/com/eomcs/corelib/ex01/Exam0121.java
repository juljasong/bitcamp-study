// StringBuffer의 문자열 비교
package com.eomcs.corelib.ex01;

public class Exam0121 {
  public static void main(String[] args) {

    // StringBuffer를 사용할 때 주의사항!
    // StringBuffer의 내용물을 비교할 때 equals() 사용해봐야 소용없다.
    // == 연산자와 같은 결과를 출력한다.

    StringBuffer b1 = new StringBuffer("Hello");
    StringBuffer b2 = new StringBuffer("Hello");

    System.out.println(b1 == b2); // false
    System.out.println(b1.equals(b2)); // false -> StringBuffer의 equals는 오버라이딩 되어 있지 않기 때문에
    // 인스턴스 주소의 값을 비교한다.

    // 해결책?
    // => StringBuffer에서 String을 꺼내 비교하라!
    System.out.println(b1.toString().equals(b2.toString())); // true

  }
}





