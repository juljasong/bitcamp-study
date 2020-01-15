// 서브 인터페이스 구현 - 수퍼 인터페이스의 메서드까지 모두 구현해야 한다.
package com.eomcs.oop.ex09.c;

public class Exam01 implements B {
  
  // 인터페이스 구현
    public void m2() {} // B 인터페이스 뿐만아니라,
    public void m1() {} // B의 수퍼인터페이스의 메서드까지 구현해야 한다.
    
    // 클래스에서 추가한 메서드
    public static void main(String[] args) {
      Exam01 obj = new Exam01();
      
      obj.m1();
      obj.m2();
      //obj.x1();
      //obj.x2();
      
      B obj2 = obj;
      obj2.m1();
      obj2.m2();
      //obj2.x1();
      //obj2.x2();
      
      A obj3 = obj;
      obj3.m1();
      //obj3.m2();
      //obj3.x1();
      //obj3.x2();
      
    }
}
