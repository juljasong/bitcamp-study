package com.eomcs.basic.ex03;
// 부동소수점 리터럴 - 부동소수점을 메모리에 저장하기

public class Exam34 {

  public static void main(String[] args) {

    // 4바이트 부동소수점 유효 자릿수 : 7자리
    
    System.out.println(3.141592f); //3.141592
    System.out.println(314.1592f); //314.1592
    System.out.println(3141.592f); //3141.592
    System.out.println(31415.92f); //31415.92
    System.out.println(314159.2f); //314159.2
    System.out.println(3.1415926535f); //3.1415927
    System.out.println(3.141592653f); //3.1415927
    System.out.println(3.14159265f); //3.1415927
    System.out.println(3.1415926f); //3.1415925
    System.out.println(3.141592f); //3.141592(OK)
    System.out.println(3141592.6f); //3141592.5 (Error)

    // 8바이트 부동소수점 유효 자릿수 : 15자리
    System.out.println(3.141592653589793); // 16자리 OK
    System.out.println(31415926.53589793); // 3.141592653589793E7 OK
    System.out.println(314159265358979.3); // 3.141592653589793E14 OK

    //16자리인 경우 일부 부동소수점의 값이 제대로 저장되지 않음
    System.out.println(914159265358979.3); // 9.141592653589792E14 Error
    System.out.println(91415926.53589793); // 9.141592653589793E7 OK
    System.out.println(9.141592653589793); // 9.141592653589793 OK

    //15자리인 경우 대부분 부동소수점의 값이 제대로 저장된다
    System.out.println(91415926535897.9); // 9.14159265358979E13 OK
    System.out.println(91415926.5358979); // 9.14159265358979E7 OK
    System.out.println(9.14159265358979); // 9.14159265358979 OK

  }
}
// boolean 값을 다룰 때 메모리 크기 : JVM (4바이트)