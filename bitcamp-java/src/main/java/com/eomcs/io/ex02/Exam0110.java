// Byte Stream - 바이트 단위로 출력하기
package com.eomcs.io.ex02;

import java.io.FileOutputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    // 1) 파일로 데이터를 출력하는 객체를 준비한다.
    // - new FileOutputStream("파일경로") -> 지정된 경로에 해당 파일 자동 생성
    // - 기족에 같은 이름의 파일이 있으면 덮어씀
    // 파일 경로가 절대 경로가 아니면 :
    // - Linux/Unix : /로 시작하지 않으면
    // - Windows : c:\, d:\ 등으로 시작하지 않으면
    // 현재 디렉토리가 기준.
    FileOutputStream out = new FileOutputStream("temp/test1.data");

    // 2) 1바이트를 출력한다.
    // => int 값을 아규먼트로 넘기더라도 맨 마지막 1바이트만 출력한다.
    out.write(0x7a6b5c4d); // 출력하는 값은 0x4d 이다.

    // 3) 출력 도구를 닫는다.
    // => OS에서 관리하는 자원 중에서 한정된 개수를 갖는 자원에 대해 여러 프로그램이 공유하는 경우,
    // 사용 후 OS에 반납해야 함
    // 그래야 다른 프로그램이 해당 자원을 사용할 수 있다 (ex. 파일, 메모리, 네트워크 연결 등)
    // 이런 자원을 사용하는 클래스는 자원을 해제시키는 .close() 존재
    // => 어떤 입출력 도구는 닫지 않으면 버퍼(임시메모리)에 남아있는 데이터가
    // 출력되지 않고 버려진다. 물론 JVM 종료하면.. 다 사라지지만..
    // 24시간 365일 멈추지 않고 실행하는 서버 프로그램의 경우에는 사용한 자원을 즉시 해제시키지 않으면, 자원 부족 문제 발생
    // -> 간단한 코드 작성시에도 .close() 호출하는 것이 나레타 호오가 이이~
    out.close();

    System.out.println("데이터 출력 완료!");

  }

}
// 파일 입출력 API 주요 클래스(java.io 패키지)
// 1) 데이터 읽기
// - InputStream (추상 클래스)
// +-- FileInputStream : 바이트 단위로 읽기 (binary stream)

// Reader (추상 클래스)
// +-- FileReader : 문자 단위로 읽기 (character stream)

// 2) 데이터 쓰기
//
// OutputStream (추상 클래스)
// +-- FileOutputStream : 바이트 단위로 쓰기
//
// Writer (추상 클래스)
// +-- FileOutputStream : 문자 단위로 쓰기
