package com.eomcs.basic.ex04;

public class Exam31 {
  public static void main(String[] args) {

    // 부동소수점 변수의 메모리 크기

    float f;

    f = 3.141592f;
    System.out.println(f); // 3.141592

    f = 3.1415929f;
    System.out.println(f); // 3.141593(E)
    
    f = 0.0000003141592f;
    System.out.println(f); // 3.141592E-7

    f = 0.00000031415929f; // 소수점 이하인 경우 앞의 0 제거
    System.out.println(f); // 3.1415928E-7(E)

    f = 31415920000.0f; // 소수점 이상인 경우 뒤의 0 포함해서 유효자릿수 계산
    System.out.println(f); // 3.14159206E10(E)

    double d;
    d = 9.87654321234567; // 15자리
    System.out.println(d);

    d = 98765432.1234567; // 15자리
    System.out.println(d); // 9.87654321234567E7
    
    d = 98765432123456.7; // 15자리
    System.out.println(d); // 9.87654321234567E13

    d = 9.876543212345678; // 16자리
    System.out.println(d); // 9.876543212345679(E)

    d = 9.876543212345674; // 16자리
    System.out.println(d); // 9.876543212345673(E)

    // 변수
    f = 99999.88f;
    System.out.println(f); // 99999.88

    f = 99999.88777f; // 이미 리터럴이 4바이트 유효자릿수를 넘어감
    System.out.println(f); // 99999.89 (E)
    
    d = 99999.88f;
    System.out.println(d); // 99999.8828125 (E)

    d = 99999.88;
    System.out.println(d); // 99999.88

    float f1 = 99988.88f;
    float f2 = 11.11111f;
    System.out.println(f1);
    System.out.println(f2);
    float f3 = f1 + f2;
    System.out.println(f3); // 99999.99(E) 99999.99111

    double d1 = 99988.88;
    double d2 = 11.11111;
    double d3 = d1 + d2;
    System.out.println(d3); // 99999.99111

    f1 = 3.141592f;
    d1 = f1; // 컴파일 OK. 값이 왜곡될 수 있음
    System.out.println(d1);

    f1 = d1; // 컴파일 오류.

  }
}