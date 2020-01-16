// non-static nested class == inner class
package com.eomcs.oop.ex11.a;

public class Exam0111 {

  /* 스태틱 필드 */
  static int sValue;
  static void sm() {}
  
  /* 인스턴스 멤버 */
  int iValue;
  void im() {}
  
  
  static class A {
    void m1() {
     
    }
  }
  
  static void m1() {
    A obj;
    obj = new A(); // OK
  }
  
  void m2() {
    A obj;
    obj = new A(); // 인스턴스 멤버는 스태틱 멤버 사용 가능
  }
  
  public static void main(String[] args) {
    
  }

}
