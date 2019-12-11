package com.eomcs.basic.ex04;

public class Exam151 {
  public static void main(String[] args) {

    // 변수(메모리) 선언 위치
    int i;
    i = 100;
    
    System.out.println(i);
    
    int j;
    j = i; // i 변수에 들어있는 값을 j에 넣는 것

    // 할당연산자 '=' : 변수에 값을 넣는 일을 함      (변수가 와야함)l-value = r-value(값/변수/표현식 올 수 있음)
    // 비교연산자 '==' :

    j = 300;
    j = i;
    j = i * 3;
    j = Math.abs(-200); // 절대값
    j = (i > 300) ? 1 : -1 ;
    //j = System.out.println(100); // 값을 리턴하는 문장이 아닌 명령어임 

    // 문장(statement)
    // - 자바 언어로 작성한 명령어
    // 표현식(expression)
    // - 실행하면 값을 리턴하는 문장

  }
}