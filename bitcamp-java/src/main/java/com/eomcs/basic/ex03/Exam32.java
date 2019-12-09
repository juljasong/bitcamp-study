package com.eomcs.basic.ex03;
// Literal

public class Exam32 {

  public static void main(String[] args) {

    // 부동소수점 : 4바이트, 8바이트

    // 8바이트 부동소수점
    System.out.println(3.141592653589793); 
    System.out.println(3.141592653589793d); 

    // 4바이트 부동소수점
    // 부동소수점의 경우 큰 값을 작은 메모리에 넣더라도 컴파일 오류가 발생하지 않는다.
    // 값이 잘려서 들어가 개발자가 잘못된 값을 넣었다는 것을 인지하지 못함.
    System.out.println(3.141592653589793f); // 3.1415927

  }
}