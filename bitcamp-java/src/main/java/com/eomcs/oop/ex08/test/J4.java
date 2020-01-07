package com.eomcs.oop.ex08.test;
/* 추상 메서드 : 서브 클래스에서 반드시 재정의 해야 하는 메서드는 문법으로 강제시킬 수 있다 */

public class J4 {
  public void m1() {
    Student s = new Student();
    Teacher t = new Teacher();
    
    
  }
  
  abstract class Member {
    String email;
    String pwd;
    String name;
    String tel;
    
    abstract void print(); // 추상 메서드 -> 호출 불가 => 서브 클래스에서 재정의 하여 호출
    // 인스턴스를 생성할 수 있는 일반 클래스는 추상 메서드를 가질 수 없고, 추상클래스(혹은 인터페이스) 만이 추상 메서드를 가질 수 있다.
  }

  // 추상 클래스는 추상 메서드를 가지지 않아도 된다.
  abstract class Student extends Member{
    int grade;
    boolean working;
  }

  // 추상 메서드를 재정의한 일반 클래스
  class Teacher extends Member{
    int pay;
    String major;
    
    @Override
    void print() {
      System.out.println("강사 정보");
    }
  }
  
}
