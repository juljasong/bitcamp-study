package com.eomcs.basic.ex04;

public class Exam23 {
  public static void main(String[] args) {

    // 크기 다른 변수끼리 값 저장하기

    byte b = 100;
    short s = 100;
    int i = 100;
    long l = 100;

    byte b2;
    short s2;
    int i2;
    long l2;

    // 큰 메모리 값을 작은 메모리에 저장할 때 (컴파일 오류)
    //b2 = l;
    //s2 = l;
    //i2 = l;
    l2 = l;

    //b2 = i;
    //s2 = i;
    i2 = i;
    l2 = i;

    //b2 = s;
    s2 = s;
    i2 = s;
    l2 = s;

    b2 = b;
    s2 = b;
    i2 = b;
    l2 = b;

    // 작은 메모리 값을 큰 메모리에 저장하는 것은 문제가 되지 않는다.

  }
}