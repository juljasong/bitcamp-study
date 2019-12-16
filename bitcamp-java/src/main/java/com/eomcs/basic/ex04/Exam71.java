package com.eomcs.basic.ex04;
// 변수의 종류
public class Exam71 {
  
  int instanceVar; // 인스턴스 필드(변수) : new 명령을 실행할 때 준비되는 변수
  static int classVar; // 클래스 필드(변수) = 스태틱 필드(변수) : 클래스가 로딩될 때 준비되는 변수
  
  public static void main(String[] args/*로컬 변수(파라미터)*/) {

    int local; // 로컬 변수 -> 메소드 블록 안에 선언된 변수 : 메소드를 실행할 때 준비되는 변수
               // 메소드 블록을 벗어나서 사용할 수 없다.
    int local2;

  }

  static void m1() {
    // 메소드 블록이 다르면 변수도 다르다. 즉, 같은 이름의 변수를 선언할 수 있다.
    int local; // 로컬 변수
    
    // 다른 메소드 블록에 있는 변수를 사용할 수 없다.
    //local2 = 100;
    
    // 같은 static 멤버는 사용할 수 있다.
    classVar = 100;
    
    //instanceVar = 300;
  }
  
  void m2() {
    int local; 
    classVar = 200;
    instanceVar = 200; // static  안붙은 변수 사용 가능.
    
  }
  
}