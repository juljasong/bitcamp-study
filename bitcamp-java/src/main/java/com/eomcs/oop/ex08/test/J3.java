package com.eomcs.oop.ex08.test;
/* 보통 Generalization으로 정의한 수퍼 클래스는 추상 클래스로 만든다 */

public class J3 {
  public void m1() {
    Student s = new Student();
    Teacher t = new Teacher();
    
    // Member m = new Member(); -> 추상 클래스
  }
  
  abstract class Member {
    String email;
    String pwd;
    String name;
    String tel;
    
    void print() {}
  }

  class Student extends Member{
    int grade;
    boolean working;
    
    @Override
    void print() {
      System.out.println("학생 정보");
    }
  }

  class Teacher extends Member{
    int pay;
    String major;
    
    @Override
    void print() {
      System.out.println("강사 정보");
    }
  }
  
}
