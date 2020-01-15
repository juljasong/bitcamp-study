// 다중 인터페이스 구현
package com.eomcs.oop.ex09.c;

// 클래스는 여러 개의 규칙을 이행할 수 있다.
public class Exam02 implements B, C {
    public void m2() {} // B 인터페이스 뿐만아니라,
    public void m1() {} // B의 수퍼인터페이스의 메서드까지 구현해야 한다.
    public void m3() {} // C의 인터페이스 구현 
    
    public static void main(String[] args) {
      Exam02 obj = new Exam02();
      
      // 다수의 인터페이스를 구현했을 때, 각 인터페이스로 구분하여 객체 사용 가능
      //B 인터페이스 레퍼런스에 담으면 B규칙에 따라
      B obj2 = obj;
      obj2.m1();
      obj2.m1();
      
      //C 인터페이스 레퍼런스에 담는다면 C규칙에 따라
      C obj3 = obj;
      obj3.m3();
    }
}
