// Wrapper 클래스 - wrapper 객체의 값 비교 
package com.eomcs.corelib.ex01;

public class Exam0230 {
  public static void main(String[] args) {
    Integer obj1 = new Integer(100); // Heap에 인스턴스 생성 
    Integer obj2 = new Integer(100); // Heap에 인스턴스 생성 
    System.out.println(obj1 == obj2); // false
    // new -> 같은 값이라도 다른 인스턴스

    Integer obj3 = 100; 
    Integer obj4 = 100; 
    System.out.println(obj3 == obj4); // true
    // 정수 리터럴을 이요해 오토 박싱으로 생성된 객체는 constants pool에 생성
    // 같은 값을 가지는 객체가 여러 개 존재해야 할 필요 없으니, 가능한 이 방법을 사용하는 것이 좋음

    Integer obj5 = Integer.valueOf(100); 
    Integer obj6 = Integer.valueOf(100); 
    System.out.println(obj5 == obj6); // true
    // wrapper 클래스의 valueOf()로 객체를 생성하는 경우 constants pool에 생성 = auto-boxing
    
    System.out.println(obj3 == obj5); // 정수 리터럴 = wrapper : true

  }
}






