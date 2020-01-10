// Wrapper 클래스 - 종류
package com.eomcs.corelib.ex01;

public class Exam0211 {
  public static void main(String[] args) {
    // 자바는 primitive data type의 값을 다룰 때 기본 연산자 외에  
    // 좀 더 다양한 방법으로 다루기 위해 
    // primitive data type에 대응하는 클래스를 제공한다.
    // 예)
    Byte b = Byte.valueOf((byte) 100);               // ==> byte
    Short s = Short.valueOf((short)20000);          // ==> short
    Integer i = Integer.valueOf(3000000);           // ==> int
    Long l = Long.valueOf(60000000000L);            // ==> long
    Float f = Float.valueOf(3.14f);                 // ==> float
    Double d = Double.valueOf(3.14159);             // ==> double
    Boolean bool = Boolean.valueOf(true);           // ==> boolean
    Character c = Character.valueOf((char)0x41);    // ==> char

    // 이렇게 primitive data type에 대응하여 만든 클래스를 
    // primitive data를 포장하는 객체라고 해서 
    // "랩퍼(wrapper) 클래스"라 부른다.

    // 래퍼 클래스 주요 용도 : 
    // => primitive data type의 값을 객체로 주고 받을 때 사용
    // primitive data type의 값을 객체에 담아 전달하고 싶다면
    // 언제든 wrapper 클래스의 인스턴스를 만들면 된다.
    
    // Wrapper 클래스의 인스턴스 생성할 때는 생성자 대신 클래스 메서드 사용

  }
}






