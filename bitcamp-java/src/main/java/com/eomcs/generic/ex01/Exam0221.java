// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0221 {
  
  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  
  public static void main(String[] args) {
    
    m1(new ArrayList());
    m1(new ArrayList<String>());
    
    m1(new ArrayList<Object>());
    
  }
  
  private static void m1 (ArrayList<?> list) {  //모든 타입에 대해 ArraytList 객체를 파라미터로 넘길 수 있음
    
  }
}








