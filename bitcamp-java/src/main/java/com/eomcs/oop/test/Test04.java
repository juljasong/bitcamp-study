package com.eomcs.oop.test;

public class Test04 {
  
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
    
    // 레퍼런스의 주소를 없애는 방법
    m1 = null; // 주소가 없다는 의미로 실제 메모리에 0으로 설정됨
    System.out.println(m1); //null
    System.out.println(m1.no); //NullPointerException
  }
}
