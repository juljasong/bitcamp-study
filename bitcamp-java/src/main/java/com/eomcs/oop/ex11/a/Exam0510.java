// 익명 클래스의 쓰임 : 스태틱 필드, 인스턴스 필드, 로컬 변수, 파라미터, 파라미터 + 람다
package com.eomcs.oop.ex11.a;

// 인터페이스의 경우 static으로 선언하지 않아도 static 멤버에서 사용할 수 있다.
public class Exam0510 {

  interface A {
    void print();
  }

  // 로컬 변수의 값 준비
  void m1() {
    A obj2 = new A() {
      public void print() {
        System.out.println("Hello!");
      }
    };
  }

  // 파라미터
  void m1(A obj) {
    obj.print();
  }


  // static 필드의 값 준비
  static A obj = new A() {
    public void print() {
      System.out.println("Hello!");
    }
  };

  // 인스턴스 필드 값 준비
  /*
  A obj1 = new A() {
    public void print() {
      System.out.println("Hello!");
    }
  };
   */
  // 람다
  A obj1 = () -> System.out.println("Hello!");

  public static void main(String[] args) {
    Exam0510 r = new Exam0510();
    r.m1();

    r.m1(new A() {
      public void print() {
        System.out.println("안녕!");
      }
    });
  }

}
