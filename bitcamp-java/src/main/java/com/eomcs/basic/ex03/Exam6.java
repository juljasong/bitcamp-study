package com.eomcs.basic.ex03;

// 문자열 리터럴

public class Exam6 {

  public static void main(String[] args) {
    
    // " " 사용하여 문자열을 나열

    System.out.println("홍길동");
    System.out.println("가"); // 문자가 아닌 문자열

    // + 연산자(operator : 특정 기능을 수행하는 명령)를 이용하여 여러 개의 문자열을 하나로 합쳐 새 문자열을 만들 수 있다
    System.out.println("이름 : 홍길동, " + 20 + "살");
    System.out.println("취업여부 : " + false);
    System.out.println("키 : " + 180.7f);
    // 문자열 + 다른 타입의 값 => 다른 종류의 값을 문자열로 먼저 변환하여 기존 문자열에 결합
  }
}

// 문자열의 저장?
// - 자바는 char(2byte) 배열에 문자열의 유니코드(Unicode; UCS-2)문자열을 저장함
// ex) "AB가각"
//    [0041][0042][ac00][ac01] <== 2바이트 메모리 4개에 저장됨