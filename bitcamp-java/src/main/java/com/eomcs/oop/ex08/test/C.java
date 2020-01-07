package com.eomcs.oop.ex08.test;
/* static - non-static -> this? */
public class C {
  
  // 스태틱 멤버는 보통 인스턴스 없이 호출 -> Static context에서는 this 사용할 수 없음.
  static void m1() {
    // Object obj = this; // 컴파일 오류 : this 변수 없음.
  }
  
  static {
    // Object obj = this; 
  }
  
  // 인스턴스 멤버는 인스턴스 주소 잇어야 사용할 수 있음 -> 인스턴스 멤버 호출하는 주소는 내장 변수 this에 저장됨
  int m2() { 
    Object obj = this;
    return 0; 
    }
  
  {
    Object obj = this;
  }

  C() {}
  
}
