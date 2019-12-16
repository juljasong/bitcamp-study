// 산술 연산자 : 명시적 형변환
package com.eomcs.basic.ex05;

public class Exam01_7 {
  public static void main(String[] args) {
    
    byte b;
    
    //b = 256;
    // 4바이트 크기를 갖는 정수 리터럴을 byte 변수에 저장할 수 없음
    
    // 저장하고 싶으면 형변환(Type Casting)을 명시적으로 지정하라
    // But, 메모리에 들어가기에 큰 값이면 형 변환할 때 값이 잘린다. 
    b = (byte)256;
    // 0000 0000 0000 0000 0000 0001 0000 0000
    // 4바이트 중에서 앞의 3바이트가 짤리고 뒤의 1바이트가 
    // b에 저장된다.
    System.out.println(b); // 0
    
    // 결론!
    // 큰 메모리 값을 작은 메모리에 넣으려고 형변환을 사용하기도 하지만, 형변환 하더라도 값이 소실되지 않을 때만 헤~
  }
}
