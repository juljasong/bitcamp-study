// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

public class Exam0112 {

    public static void main(String[] args) throws Exception {
      
        // 한글 문자 코드 바이트 배열로 String 인스턴스 초기화
        byte[] bytes = {
            (byte)0xb0, (byte)0xa1, 
            (byte)0xb0, (byte)0xa2, 
            (byte)0xb6, (byte)0xca, 
            (byte)0xb6, (byte)0xcb
            };
        String s1 = new String(bytes);
        System.out.println(s1); // => 한글 출력 깨짐. 
        // String 클래스는 파라미터로 넘겨 받은 바이트 배열을 가지고 유니코드 문자열 값으로 변환할 때 바이트 배열이 OS의 기본 문자 코드로 간주
        // OS 마다 기본으로 사용하는 문자 코드 (Character set)가 다름.
        // windows : MS949
        // Unux/Linux/macOS : UTF-8
        // => 위 예제의 바이트 배열은 유니코드.
        
        String s2 = new String(bytes, "EUC-KR");
        System.out.println(s2);
        
    }
}