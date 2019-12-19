package com.eomcs.oop.test;

public class Test02 {
  
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
    
    // "사용자 정의 데이터 타입(user defined data type)"
    // class로 만든 데이터 타입으로, 메모리를 만들 때는 일반적인 방식으로 만들 수 없고, new 를 사용해야한다.
    // 준비된 메모리를 사용하기 위해서 변수에 보관하는 메모리의 주소 : "reference"
    Member m1 = new Member();
    
    // m1
    // - Member 설계도에 따라 준비된 메모리의 주소를 저장할 변수
    // - 다른 설계도로 만든 메모리의 주소를 저장할 수 없음
    // - Member 설계도로 만든 메모리는 이 변수를 통해 접근할 수 있음.
    
    // new Member()
    // - Member 설계도에 따라 사용할 수 있도록 준비된 메모리를 준비
    // - "Instance" 혹은 "Object"라고 한다.
    
    // 사용법 
    // - 레퍼런스를 통해 해당 메모리에 접근 가능
    m1.no = 100;
    m1.name = "홍길동";
    
  }
}
