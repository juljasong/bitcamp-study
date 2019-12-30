// 인스턴스 초기화 블록(Initializer block) - 생성자와 인스턴스 초기화 블록
package com.eomcs.oop.ex03;

public class Exam0612 {
  static class A {
    int a;
    int b;
    int c;
    
    /* 인스턴스 초기화 블록 : 여러 생성자에 공통으로 존재하는 코드가 있다면 별도의 블록으로 뽑아내야 함! */
    {
      System.out.println("Hello!");
      a = 100;
    }
    
    // 자바 컴파일러는 필드 초기화(variable initializer)나 인스턴스 초기화 블록(initializer block)이 있을 때, 
    // 선언된 순서대로 모든 생성자의 첫 부분에 복사
    
    A() {
      System.out.println("A()");
      b = 200;
      c = 300;
    }
    
    A(int b) {
      System.out.println("A(int)");
      this.b = b;
    }
    
    A(int b, int c) {
      System.out.println("A(int, int)");
      this.b = b;
      this.c = c;
    }
  }
  
  public static void main(String[] args) {
    A obj1 = new A();
    System.out.printf("a=%d, b=%d, c=%d\n", obj1.a, obj1.b, obj1.c);
    A obj2 = new A(222);
    System.out.printf("a=%d, b=%d, c=%d\n", obj2.a, obj2.b, obj2.c);
    A obj3 = new A(222, 333);
    System.out.printf("a=%d, b=%d, c=%d\n", obj3.a, obj3.b, obj3.c);
  }
  
}





