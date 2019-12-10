package com.eomcs.basic.ex03;

// 문자열 리터럴

public class Exam7 {

  public static void main(String[] args) {
    
     // 이스케이프 문자
     // - 문자를 제어하는 기능을 가진 문자
     // - 문법
     // \[n|r|f|t|b|'|"|\]

    System.out.println("Hello, World!");
    System.out.println("Hello, \nWorld!"); // 줄바꿈
    System.out.println("Hello, \rWorld!"); // 커서(cursor) : 문자를 출력할 위치 가리킴
    System.out.println("Hello, \b\b\bWorld!"); //커서를 뒤로 한 칸 이동
    System.out.println("Hello, \tWorld!"); // tab
    System.out.println("Hello, \fWorld!"); // formfeed 추가
    System.out.println("Hello, \"W\"orld!"); // " " 안에서 " 출력
    System.out.println("Hello, 'W'orld!"); // " " 안에서 ' 문자는 출력 가능
    System.out.println('\''); // ' ' 안에서 ' 출력
    System.out.println('\''); // ' ' 안에서 " 문자는 출력 가능
    System.out.println("c:\\Users\\user\\git"); // 
  }
}