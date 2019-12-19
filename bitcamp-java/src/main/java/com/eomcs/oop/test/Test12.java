package com.eomcs.oop.test;

public class Test12 {
  
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
    
    // 여러개의 인스턴스 주소 저장하려면 당연히 여러 개의 레퍼런스 필요
    // 레퍼런스 변수 여러 개 만들기
    //Member m0, m1, m2, m3, m4;
    /*
    m0 = new Member();
    m1 = new Member();
    m2 = new Member();
    m3 = new Member();
    m4 = new Member();
    
    m0.no = 100;
    m1.no = 200;
    m2.no = 300;
    m3.no = 400;
    m4.no = 500;
    */
    //각 변수에 인스턴스 
   // 레퍼런스 배열
   //new Member[5]; // 인스턴스를 생성한 후 그 주소를 반드시 저장해야 한다.
    
    //배열 주소를 저장할 변수 선언 => 배열 주소를 저장하는 변수도 Reference
    //배열 선언
    Member[] arr = new Member[5];
    /*
    int count = 0;
    while (count < 3000) {
      arr[count] = new Member();
      count++;
    }
    */
    arr[0] = new Member();
    arr[0].no = 1;
    System.out.println(arr[0].no);
    
    System.out.println("OK!");
  }
}
