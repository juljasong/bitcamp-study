package com.eomcs.oop.ex03;

public class Exam0632 {

  static class A {
    
    /* 1) 필드 선언 및 초기화 문장
       2) static block (가능한 1개 유지)
       3) instance block
       4) 생성자 (기본 생성자 -> 파라미터 1개 -> 2개 -> ...)*/
    
    
    // 1) 필드 초기화 문장(variable initializer)
    int a = 100;
    
    // 2) 인스턴스 초기화 블록 (initializer block)
    {
      this.a = 200;
      System.out.println("초기화 블록");
    }
    
    // 3) 생성자
    A() {
      // 자바 컴파일러는 인스턴스 초기화 블록이나 필드 초기화 문장이 있다면, 선언된 순서대로 복사
      System.out.println("A()");
      a = 300;
    }
    
    A(int a) {
      System.out.println("A(int)");
      this.a = a;
    }
    
    


  }

  public static void main(String[] args) {
    A obj1 = new A();
    System.out.println(obj1.a);
    System.out.println("=============");
    A obj2 = new A(1111);
    System.out.println(obj2.a);
  }
}





