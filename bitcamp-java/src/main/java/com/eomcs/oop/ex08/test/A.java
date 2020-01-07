package com.eomcs.oop.ex08.test;


// package member class
// public이 아닌 클래스를 여러 개 정의할 수 있지만, 하나의 클래스에 하나의 클래스만 선언하도록.
class A1 {}
class A2 {}


// package member class
public class A {
  // 클래스 안에 선언된 클래스
  // nested class (non-static nested class, inner class, 중첩 클래스)
  class X {}
  
  // static nested class
  static class X2 {}
  
  void m() {
    // local class
    class Y {}
    
    // 익명 클래스(Anonymous Class)는 선언하고 바로 사용해야 하며, 수퍼클래스를 따로 지정해야 한다.
   Object obj = new Object(){
      @Override
      public String toString() {
        return "익명 클래스";
      }
    };
    
    Y objY = new Y();
  }

}
