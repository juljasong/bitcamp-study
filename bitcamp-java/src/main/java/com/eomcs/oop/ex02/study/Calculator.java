package com.eomcs.oop.ex02.study;

public class Calculator {
  
  // 계산 결과를 개별적으로 관리하기 위해서는 인스턴스 필드로 선언해야 함.
  int result;
  
  //개별적으로 관리되는 인스턴스 변수 result를 사용하고 싶다면, 파라미터로 인스턴스 주소 받아야 함 
  
  void plus (int value) {
    this.result += value;
  }
  
  void minus (int value) {
    this.result -= value;
  }
  
  void multiple (int value) {
    this.result *= value;
  }
  
  void divide (int value) {
    this.result /= value;
  }
 

}
