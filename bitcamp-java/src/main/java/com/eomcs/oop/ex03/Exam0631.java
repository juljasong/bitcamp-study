// 인스턴스 초기화 블록과 필드 초기화, 생성자의 실행 순서
package com.eomcs.oop.ex03;

public class Exam0631 {

  static class A {
    
    // 최종 결과(마지막에 실행될 수록 값을 덮어씌움) : 생성자(){} > 인스턴스 초기화 블록{} > 필드 초기화 문장
    
    // 3) 생성자 실행
    A() {
      // 자바 컴파일러는 인스턴스 초기화 블록이나 필드 초기화 문장이 있다면, 선언된 순서대로 복사
      System.out.println("A()");
      a = 300;
    }
    
    A(int a) {
      System.out.println("A(int)");
      this.a = a;
    }

    // 2) 인스턴스 초기화 블록 (initializer block)
    {
      a = 200;
      System.out.println("초기화 블록");
    }

    // 1) 필드 초기화 문장(variable initializer)
    int a = 100;
  }

  public static void main(String[] args) {
    A obj1 = new A();
    System.out.println(obj1.a);
    System.out.println("=============");
    A obj2 = new A(1111);
    System.out.println(obj2.a);
  }
}





