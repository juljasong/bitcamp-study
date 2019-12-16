package com.eomcs.basic.ex04;

// 형변환 : 형변환 규칙
public class Exam92 {
  

  public static void main(String[] args) {
    
    // 1) 정수 메모리끼리 형변환 가능
    byte b = 127;
    short s = 32767;
    int i = 21_0000_0000;
    long l = 922_0000_0000_0000_0000L;
    
    i = (int) l;
    s = (short) i;
    s = (byte) s; 
    //값이 잘릴 수 있음.
    
    // 2) 부동소수점을 정수 메모리에 저장 가능
    
    // 3) 정수를 부동소수점 메모리에 저장 가능. 
    
    // 4) 숫자를 문자 변수에 저장 가능
    i = 65;
    char c = (char) i;
    System.out.println(c);
    
    // 그 외 불가.
    boolean bool;
    //bool = b;
    //bool = s;
    //bool = i;
    
  }
  
}