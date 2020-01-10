// 제네릭(Generic) - 사용 전
package com.eomcs.generic.ex01;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam0110 {
  
  // 제네릭이 없다면 각 타입의 객체를 저장하기 위해 다음과 같익가 타입에 대한 클래스를 정의해야 함
  static class MemberBox {
    Member value;
    
    public void set(Member value) {
      this.value = value;
    }
    
    public Member get() {
      return value;
    }
  }
  
  static class StringBox {
    String value;
    
    public void set(String value) {
      this.value = value;
    }
    
    public String get() {
      return value;
    }
  }
  
  static class IntegerBox {
    Integer value;
    
    public void set(Integer value) {
      this.value = value;
    }
    
    public Integer get() {
      return value;
    }
  }
  
  public static void main(String[] args) {
    // Member 객체를 저장하려면 MemberBox를 사용해야 함
    MemberBox box1 = new MemberBox();
    box1.set(new Member("홍길동", 16));
    
    // 값 꺼내기
    Member m = box1.get();
    System.out.println(m);
    
    /* String */
    StringBox box2 = new StringBox();
    box2.set(new String("Hello"));
    String str = box2.get();
    System.out.println(str);
    
    /* Integer */
    
    IntegerBox box3 = new IntegerBox();
    box3.set(100); // auto-boxing -> Integer.valueOf(100)
    int i = box3.get(); // auto-unboxing -> box3.get().intValue(
    System.out.println(i);
    
    // 객체 저장할 때, 각 객체의 타입 별로 Box 클래스를 생성해야 함 -> 코드가 쓸데없이 길어짐
    // -> 다형적 변수 특징 이용하여 값을 저장하는 인스턴스 변수를 Object로 정의 
    // Exam0111.java
  }
}








