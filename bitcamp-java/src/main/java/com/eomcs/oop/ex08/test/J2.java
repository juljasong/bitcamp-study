package com.eomcs.oop.ex08.test;
/* Student와 Teacher의 공통 분모 뽑아 수퍼 클래스 정의 => Generalization */

public class J2 {
  
  class Member {
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
