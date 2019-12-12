package com.eomcs.basic.ex04;

public class Exam41 {
  public static void main(String[] args) {

    // 문자 변수

    short s; 
    char c;

    s = -32768;
    s = 32767;
    
    c = 0;
    c = 65535;

    char c1 = 65;
    char c2 = 0x41;
    char c3 = 0b0100_0001;
    char c4 = 'A'; // 문자 코드 값을 리턴하겠소
    System.out.println(c1); // A
    System.out.println(c2); // A
    System.out.println(c3); // A
    System.out.println(c4); // A

    int i1 = 65;
    int i2 = 0x41;
    int i3 = 0b0100_0001;
    int i4 = 'A';
    System.out.println(i1); // 65
    System.out.println(i2); // 65
    System.out.println(i3); // 65
    System.out.println(i4); // 65

    int i5 = i4 + 10;

    System.out.println(i5); // 75
    System.out.println((char)i5); // K

    for (int i = 65 ; i < 'A' + 26 ; i++){
      System.out.printf("%c", i);
    }

  }
}