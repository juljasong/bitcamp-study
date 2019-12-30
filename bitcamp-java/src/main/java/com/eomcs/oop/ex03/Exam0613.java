// 인스턴스 초기화 블록(Initializer block) - 인스턴스 초기화 블록의 위치
package com.eomcs.oop.ex03;

public class Exam0613 {
  static class A {
    int a;
    int b;
    int c;
    
    /* 인스턴스 초기화 블록은 선언된 순서대로 복사 */
    {
      System.out.println("첫 번 째 인스턴스 초기화 블록");
      this.a = 101;
    }

    
    A() {
      System.out.println("A()");
      b = 200;
      c = 300;
    }
    
    A(int b) {
      System.out.println("A(int)");
      this.b = b;
    }
    
    {
      this.a = 102;
      System.out.println("두 번 째 인스턴스 초기화 블록");
    }
    
    A(int b, int c) {
      System.out.println("A(int, int)");
      this.b = b;
      this.c = c;
    }
    
    {
      this.a = 103;
      System.out.println("세 번 째 인스턴스 초기화 블록");
    }
  }
  
  public static void main(String[] args) {
    A obj1 = new A();
    System.out.printf("a=%d, b=%d, c=%d\n", obj1.a, obj1.b, obj1.c);
    System.out.println("======================");
    A obj2 = new A(222);
    System.out.printf("a=%d, b=%d, c=%d\n", obj2.a, obj2.b, obj2.c);
    System.out.println("======================");
    A obj3 = new A(222, 333);
    System.out.printf("a=%d, b=%d, c=%d\n", obj3.a, obj3.b, obj3.c);
  }
  
}





