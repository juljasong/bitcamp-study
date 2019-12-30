// 생성자 활용 예 - java.util.Calendar 클래스의 생성자
package com.eomcs.oop.ex04;

import java.util.Calendar;

public class Exam0130 {

  public static void main(String[] args) throws Exception {
    // 생성자가 있다하더라도 접근 권한이 없다면, 생성자를 호출할 수 없다.
    // 이런 경우 new 명령으로 인스턴스를 생성할 수 없다.
    // Calendar c = new Calendar(); // 컴파일 오류!

    // 생성자의 사용 권한을 막는 경우
    // 1) 같은 값을 갖는 객체 쓸데없이 여러 개 생성 X => 메모리 절약
    // 2) 객체 생성과정이 복잡할 때

    // Calendar 클래스의 경우도 생성자를 protected로 
    // 같은 달력을 여러개 쓸데없이 여러개 생성하지 못하도록 생성자를 protected로 막고 있음
    // 대신 클래스 메서드를 통해 생성하도록 요구
    Calendar c1= Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    System.out.println("c1 == c2");
    // getInstance() 호출 시점의 시각이 다르기 때문에 두 객체의 주소는 다름
    
    // 이렇게 자바에서 생성자의 사용 권한을 막고 메서드를 호출하여 객체를 생성ㄹ하도록 유도하는 경우
    // 1) 같은 값을 갖는 객체를 쓸데없이 여러 개 생성하지 못하도록 할 때 => 메모리 절약 : Singleton
    // 2) 객체 생성 과정이 복잡할 때 => 객체 생성 코드 단순화, 생성된 객체 재활용 : Factory Method
  }
}














