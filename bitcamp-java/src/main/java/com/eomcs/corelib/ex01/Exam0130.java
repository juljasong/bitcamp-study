// String - mutable vs immutable 객체
package com.eomcs.corelib.ex01;

public class Exam0130 {
  public static void main(String[] args) {
    // String 객체는 immutable 객체이다.
    // 즉 한 번 객체에 값을 담으면 변경할 수 없다.

    String s1 = new String("Hello");

    // String 클래스의 메서드는 원본 인스턴스 데이터 변경 하는 것이 아닌, 새로 String 객체를 만든다.
    String s2 = s1.replace('l', 'x');
    System.out.printf("%s : %s\n", s1, s2); // 원본은 바뀌지 않는다.

    String s3 = s1.concat(", world!");
    System.out.printf("%s : %s\n", s1, s3); // 원본은 바뀌지 않는다.
  }
}





