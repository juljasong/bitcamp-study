package com.eomcs.basic.ex03;

// 문자 리터럴 - 작은 따옴표의 역할

public class Exam43 {

  public static void main(String[] args) {
    
    System.out.println(0xac00); //44032 - 정수 리터럴
    System.out.println((char)0xac00); //가 (char) : 문자코드
    System.out.println('가'); // 문자 리터럴

    System.out.println((int)'가'); //44032

    System.out.println('각' + 1); //44034
    System.out.println('각' - 1); //44032

    System.out.println((char)('각' - 1)); //가

  }
}