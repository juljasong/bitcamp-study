// 제네릭(Generic) - 문법 정리 
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0230 {
  public static void main(String[] args) {
    
    ArrayList<Object> list;
    list = new ArrayList<Object>(); 
    
    // ArrayList가 Object 타입의 데이터를 다루면, 파라미터나 리턴타입이 Object로 설정
    
    // add(Object)
    list.add(new Object());
    list.add(new String());
    list.add(new Integer(100));
    list.add(new Member("홍길동", 20));
    
    Object obj = list.get(0);
    Object str = (String)list.get(1);
    int i = (Integer)list.get(2);
    Member m = (Member)list.get(3);
    
    System.out.println("종료");


  }
}








