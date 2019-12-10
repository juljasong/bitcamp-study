package com.eomcs.basic.ex03;
// 부동소수점 리터럴 - 부동소수점의 리터럴은 왜 기본이 8바이트인가

public class Exam342 {

  public static void main(String[] args) {

    System.out.println(54345.66f);
    System.out.println(11.23456f);

    System.out.println( 54345.66f + 11.23456f ); // 7자리 + 7자리 = 10자리
    //각각의 수는 유효자릿수이지만 계산 결과가 유효자릿수를 넘어가 값이 구겨짐.
    // 이렇게 작은 부동소수점인 경우에도 유효자릿수를 쉽게 넘어가, 자바는 기본으로 8바이트 메모리를 사용한다.

    //자바로 프로그래밍을 할 때 부동소수점은 8바이트로 다루기


  }
}