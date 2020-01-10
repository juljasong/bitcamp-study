// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0211 {
  public static void main(String[] args) {
    
    ArrayList list;
    list = new ArrayList();
    list = new ArrayList<>();
    list = new ArrayList<Object>(); 
    list = new ArrayList<String>(); 
    list = new ArrayList<Member>(); 
    
    // ArrayList가 다루는 타입에 상관없이 ArrayList 레퍼런스를 선언하고 싶다면, list2 처럼 명시
    ArrayList<?> list2;
    list2 = new ArrayList();
    list2 = new ArrayList<>();
    list2 = new ArrayList<Object>(); 
    list2 = new ArrayList<String>(); 
    list2 = new ArrayList<Member>(); 

  }
}








