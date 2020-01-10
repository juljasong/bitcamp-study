// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0212 {
  public static void main(String[] args) {
    
    ArrayList<Object> list; //Object 객체만 데려올 수 있음
    list = new ArrayList();
    list = new ArrayList<>();
    list = new ArrayList<Object>(); 
    //list = new ArrayList<String>(); 
    //list = new ArrayList<Member>(); 

  }
}








