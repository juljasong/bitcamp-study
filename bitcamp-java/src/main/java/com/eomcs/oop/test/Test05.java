package com.eomcs.oop.test;

public class Test05 {
  
  public static void main(String[] args) {
    // 자바는 다양한 종류의 데이터를 담을 수 잇는 메모리를 설계하는 문법을 제공한다.
    
    // 예 : 회원 데이터를 저장할 메모리의 설계
    class Member {
    int no;
    String name;
    int birthYear;
    char gender;
    float height;
    float weight;
    boolean personalTraining;
    }
    Member m1 = new Member();
    m1.no = 100;
    Member m2 = m1;
    // 기존 레퍼런스에 새 인스턴스의 주소 저장
    // m1과 m2는 서로 다른 인스턴스의 주소를 가짐 = 다른 인스턴스
    m1 = new Member();
    m1.no = 200;
    System.out.println(m1.no); //200
    System.out.println(m2.no); //100
    
    m2 = m1;
    System.out.println(m1.no); //200
    System.out.println(m2.no); //200
    // m1과 m2는 같은 인스턴스를 가리킨다. 처음에 만들었던 인스턴스는 Garbage가 됨
    
  }
}
