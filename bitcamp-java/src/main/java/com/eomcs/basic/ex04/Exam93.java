package com.eomcs.basic.ex04;

// 형변환 : 부동소수점 변수 => 정수 변수 
public class Exam93 {
  

  public static void main(String[] args) {
    
    float f = 3.14f;
    double d = 3.14;
    
    int i;
    long l;
    
    //i = f;
    //i = d;
    //l = f;
    //l = d;
    
    // 부동소수점 값을 정수 변수에 강제로 저장시키려면 형 변환(type conversiong; casting) 해야함.
    i = (int) f; // 소수점 이하의 수는 제거되고 정수만 저장됨.
    System.out.println(i); // 3
    
    i = (int) d;
    System.out.println(i); // 3
    
    l = (long) f; 
    
    l = (long) d;
    
    // 명시적 형변환(explicit type conversion/casting) 
    
  }
  
}