package com.eomcs.basic.ex03;

// 논리 리터럴

public class Exam5 {

  public static void main(String[] args) {
    
    // 참 : true 
    // 거짓 : false
    // 자바는 대소문자 구분

    System.out.println(true);
    System.out.println(false);
    //System.out.println(TRUE);
    
    // 보통 비교 연산의 결과
    System.out.println( 5 < 4 ); // false
    System.out.println( 5 > 4 ); // true

    // 논리 연산의 결과도 논리 값

    System.out.println( true && true ); // true
    System.out.println( true && false ); // false

    System.out.println( true || true); // true
    System.out.println( true || false); // true

    //문자 코드와 ''
    // '문자' 단독으로 사용될 때에는 문자로 취급하지만 다른 값과 연산을 수행하면 해당 문자코드는 그냥 정수로 간주
    System.out.println( '가' == 44032 ); // true
    System.out.println( '가' == 44033 ); // false
    
  }
}