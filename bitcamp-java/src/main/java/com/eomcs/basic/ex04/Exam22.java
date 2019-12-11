package com.eomcs.basic.ex04;

public class Exam22 {
  public static void main(String[] args) {

    // 변수의 크기와 리터럴의 크기

    // 자바의 정수 리터럴은 4바이트와 8바이트만 있다.
    // 변수의 값을 저장할 수 있다면 허락한다.
    byte b; 
    b = 127;  // 127은 4바이트 정수 리터럴(int)이지만, b변수에 넣을 수 있는 값이면 허락

    //b = 128; // int to byte

    b = 10L; // long to byte

  }
}