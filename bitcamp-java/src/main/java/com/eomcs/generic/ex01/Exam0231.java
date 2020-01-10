// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;
import com.eomcs.generic.ex01.Exam0223.A;
import com.eomcs.generic.ex01.Exam0223.B1;

public class Exam0231 {
  
  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  public static void main(String[] args) {
    
    ArrayList<B1> list1;
    list1 = new ArrayList<B1>(); 
    
    // ArrayList가 Object 타입의 데이터를 다루면, 파라미터나 리턴타입이 Object로 설정
    
    // add(Object)
    //list1.add(new Object());
    //list1.add(new String());
    //list1.add(new Integer(100));
    //list1.add(new Member("홍길동", 20));
    
    //list1.add(new A());
    list1.add(new B1());
    //list1.add(new B2());
    list1.add(new C());
    
    System.out.println("종료");
  }
}








