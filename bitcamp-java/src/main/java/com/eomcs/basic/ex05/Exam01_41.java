// 산술 연산자 : 연산의 결과 타입  
package com.eomcs.basic.ex05;

public class Exam01_41 {
  public static void main(String[] args) {
    int i = 5;
    int j = 2;
    float r = i / j; // int와 int의 연산 결과는 항상 int이다.
    // 따라서 r 변수에 넣기 전에 
    // 이미 결과는 정수 2가 된다.
    // 정수 2를 float 변수에 넣으면 
    // 출력할 때 2.0이 된다.
    System.out.println(r);

    // 해결책!
    // - 변수에 들어 있는 값을 다른 타입으로 바꿔라.
    //   "형변환(type conversion=type casting)"하라!
    r = (float)i / (float)j; // float / float = float
    // i / j의 값은 2.5가 되고
    // r에 저장되는 것은 2.5이다.
    System.out.println(r);

  }
}

