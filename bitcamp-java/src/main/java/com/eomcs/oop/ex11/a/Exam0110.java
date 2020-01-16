// non-static nested class == inner class
package com.eomcs.oop.ex11.a;

public class Exam0110 {

  /* 스태틱 필드 */
  static int sValue;
  static void sm() {}
  
  /* 인스턴스 멤버 */
  int iValue;
  void im() {}
  
  
  static class A {
    void m1() {
      sValue = 100;
      //iVAlue = 100; //컴파일 오류 -> static 멤버는 static 멤버만 사용할 수 있음!
      
      sm();
      //im();
    }
  }
  
  // 결론 : 인스턴스 멤버 사용하지 않으면 static nested class로 
  
  public static void main(String[] args) {
    
  }

}
