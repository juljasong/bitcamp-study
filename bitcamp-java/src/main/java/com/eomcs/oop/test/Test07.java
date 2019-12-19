package com.eomcs.oop.test;

public class Test07 {
  
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
    m1.no = 10;
    System.out.println(m1); //com.eomcs.basic.ex07.test.Test03$1Member@6d311334 (고유식별번호)
    System.out.println(m1.no); //10
    
    // 다른 레퍼런스에 주소를 저장할 수 있다.
    Member m2 = m1;
    // m2와 m1의 주소 같으면, 같은 인스턴스.
    System.out.println(m1.no); //10
    System.out.println(m2.no); //10
    m1.no = 200;
    System.out.println(m1.no); //200
    System.out.println(m2.no); //200
  }
}
