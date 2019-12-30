// 초기화 블록 - 인스턴스 블록
package com.eomcs.oop.ex03;

public class Exam0610 {
  static class A {
    int a;
    int b;
    
    /* 이름 없는 초기화 블록  : 인스턴스 생성 후, 생성자 호출 전에 자동 실행 */
    { 
      System.out.println("{}11111");
    }

    A() {
      System.out.println("A()");
    }

    /* 여러 개의 초기화 블록은 순서대로 호출됨. 하지만 초기화 블록은 나눠서 정의하지 말고 하나만 정의하는 게 좋음 */
    {
      System.out.println("{}22222");
    }
  }
  public static void main(String[] args) {
    A obj1 = new A();
  }
}





