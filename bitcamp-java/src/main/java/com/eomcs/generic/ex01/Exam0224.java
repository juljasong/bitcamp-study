// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0224 {
  
  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  
  public static void main(String[] args) {
    
    //m1(new ArrayList<A>());
    m1(new ArrayList<B1>());
    //m1(new ArrayList<B2>());
    m1(new ArrayList<C>());
    
  }
  
  private static void m1 (ArrayList<? extends B1> list) {  // A만 가능
    
  }
}








