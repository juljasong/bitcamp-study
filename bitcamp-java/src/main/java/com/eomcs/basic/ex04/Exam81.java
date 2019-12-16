package com.eomcs.basic.ex04;

// 변수와 블록
public class Exam81 {
  

  public static void main(String[] args) {

    int a ;
    
    // 메소드 안에 블록을 이용하여 변수의 사용 범위 통제
    
    {
      // 블록 안에서는 블록 밖의 변수를 사용할 수 있다.
      a = 100;
      
      // 블록 안에 선언된 변수는 블록을 실행할 때 준비된다.
      int b;
      b = 200;
      // 블록을 나가면 자동으로 제거된다.
    }
    
    // b = 300;
    
    {
      // 블록 밖의 변수와 같은 이름을 가진 변수를 선언할 수 없다.
      // int a; // 컴파일 오류!
      
      int b;
      // 다른 블록의 변수와 이름이 같은 변수 선언 가능. 블록을 나갈 때 제거되기 때문.
    }
    
    if (true) {
      //int a = 200;
      int b = 200; 
    }
    //b = 300;
    
    
  }
  
}