// String - 문자열 비교
package com.eomcs.corelib.ex01;

public class Exam0120 {
  public static void main(String[] args) {
    /* Heap */
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    /* string constant pool */
    String x1 = "Hello";
    String x2 = "Hello";

    // equals()
    // Object에 오버라이딩되어 있는 메서드
    // 인스턴스 주소가 아닌 데이터가 같은지 비교

    System.out.println("s1.equals(s2)) : " + s1.equals(s2)); // true
    System.out.println("s1.equals(x1) : " + s1.equals(x1)); // true
    
    System.out.printf("s1 == s2 : %b\n", s1 == s2); // false
    System.out.printf("x1 == x2 : %b\n", x1 == x2); // true
    System.out.printf("s1 == x1 : %b\n", s1 == x1); // true
  }
}





