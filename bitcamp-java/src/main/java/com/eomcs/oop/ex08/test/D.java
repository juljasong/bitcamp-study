package com.eomcs.oop.ex08.test;
/* Inheritance */
public class D/*Sub*/ extends Object/*Super*/{
  int a;
}

class D2 extends D {
  int b;
}

class D3 extends D2 {
  int c;
}

class TestD {
  public static void main(String[] arg) {
    D3 obj = new D3(); // D3가 상속하고 있는 수퍼클래스(D, D2, D3)의 인스턴스 변수까지 생성
    obj.c = 100; // D3
    obj.b = 100; // D2
    obj.a = 100; // D
  }
}
  