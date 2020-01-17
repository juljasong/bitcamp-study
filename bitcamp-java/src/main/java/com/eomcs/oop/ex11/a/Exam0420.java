// 인터페이스 구현
package com.eomcs.oop.ex11.a;

// 인터페이스의 경우 static으로 선언하지 않아도 static 멤버에서 사용할 수 있다.
public class Exam0420 {

  interface A {
    void print();
  }

  public static void main(final String[] args) {
    
    // 인터페이스로 익명클래스 구현
    A obj = new A() {
      @Override
      public void print() {
        System.out.println("Hello!");
      }
    };
    
    obj.print();
  }
}
