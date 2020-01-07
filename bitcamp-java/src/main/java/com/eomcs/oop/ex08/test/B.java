package com.eomcs.oop.ex08.test;
/* class를 구성하는 멤버 */
public class B {
  
  // 1. field
  static int a; // 클래스(스태틱) 필드 => new 명령이 아닌, 클래스가 로딩될 때 생성
  String b; // 인스턴스 필드 = 논스태틱 필드
  
  // 2. method
  static void m1() {}  // 클래스(스태틱) 메서드
  int m2() { return 0; } // 인스턴스 메서드 = 논스태틱 메서드
  
  // 3. initializer block
  static {} // 스태틱 블록
  {} // 인스턴스 블럭
  
  // 4. constructor
  B() {}
  
  // 5. nested class
  static class B1{} // static nested class
  class B2{} // non-static nested class = inner class
  
}
