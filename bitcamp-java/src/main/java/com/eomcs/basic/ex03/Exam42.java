package com.eomcs.basic.ex03;
// 문자 리터럴

public class Exam42 {

  public static void main(String[] args) {
    // 코드 값을 안다면 직접 코드 값을 사용해 문자를 지정할 수 있음
    System.out.println(0x0041); // 00 생략 가능
    System.out.println(0xac00);
    
    // => 숫자 앞에 문자 코드임을 알리는 표시 (char)
    // 문자 코드에 해당하는 문자를 폰트 파일에서 찾아 코드에 해당하는 문자 그림 출력
    System.out.println((char)0x0041);
    System.out.println((char)0xac00);

    for ( int i = 0 ; i < 11172 ; i++ ) {
      if ( i % 80 == 0) {
        System.out.println();
      }
      System.out.print((char)(0xac00 + i));
    }

  }
}