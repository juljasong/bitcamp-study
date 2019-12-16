// 산술 연산자 : 연산의 결과 타입  
package com.eomcs.basic.ex05;

//  산술 연산자 : 암시적 형변환과 연산 우선순위
public class Exam01_6 {
  public static void main(String[] args) {
    
    float r1 = 5 / 2 + 3.1f;
    System.out.println(r1); // 5.1
    // 연산 우선 순위에 따라 계산하는 순간에 암시적 형변환이 이루어짐
    // = 모든 값을 최종 결과 타입으로 바꾸고 계산하는 것이 아님
    
    float r2 = 3.1f + 5 / 2;
    System.out.println(r2); // 5.1

    
  }
}
