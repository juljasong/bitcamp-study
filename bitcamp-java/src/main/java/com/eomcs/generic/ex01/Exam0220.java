// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0220 {
  
  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  
  public static void main(String[] args) {
    
    m1(new ArrayList());
    m1(new ArrayList<String>());
    
    m1(new ArrayList<Object>());
    
  }
  
  private static void m1 (ArrayList<Object> list) { // <T>를 설정하면, T만 가능. 하위 클래스 불가.
    
  }
}








