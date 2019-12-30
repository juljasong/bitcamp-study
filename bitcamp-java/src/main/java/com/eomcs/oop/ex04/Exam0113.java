// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

import java.util.Properties;
import java.util.Set;

public class Exam0113 {

    public static void main(String[] args) throws Exception {
      
        // 한글 문자 코드 바이트 배열로 String 인스턴스 초기화
        byte[] bytes = {
            (byte)0x41, // A
            (byte)0x42, // B
            (byte)0x43, // C
            (byte)0x61, // a
            (byte)0x62, // b
            (byte)0x63, // c
            (byte)0x30, // 0
            (byte)0x31, // 1
            (byte)0x41, // 2
            (byte)0x20, // space
            (byte)0x21, // !
            (byte)0x23, // #
            (byte)0x25, // %
            (byte)0x2b, // +
            (byte)0xea, (byte)0xb0, (byte)0x80,
            (byte)0xea, (byte)0xb0, (byte)0x81,
            (byte)0xeb, (byte)0x98, (byte)0x98,
            (byte)0xeb, (byte)0x98, (byte)0xa5
            };
        String s1 = new String(bytes);
        System.out.println(s1);
        
        // 생성자에 바이트 배열을 넘길 때
        // 바이트 배열에 들어있는 데이터의 문자 코드표를 알려주지 않으면, String 생성자는 OS의 기본 문자 코드표로 간주하여 변환
        // 따라서 위 예제를 Linux, macOS, Unix의 CLI에서 실행하면 정상적으로 한글 문자열이 출력되지만
        // 윈도우에서 실행하면 깨짐.
        
        // 이클립스에서 JVM을 실행할 때 입출력 기본 인코딩을 UTF-8로 설정
        
        // window CLI에서 깨지지 않게 출력하는 방법
        // => JVM 실행 옵션에 다음 추가
        // -Dfile.encoding=UTF-8
        // 파워셸이 아닌 커멘드에서 실행해야 함
        // 파워셸은 .를 문자로 인식해 -Dfile.encosid
        /*
        System.out.println("-------------");
        Properties props = System.getProperties(); // JVM의 환경정보 
        for (Object key : props.keySet()) {
          System.out.printf("%s ====> %s\n", key, props.get(key));
        }
        */
        
    }
}









