// URL(Uniform Resource Locator) - URL을 다루는 클래스
package com.eomcs.net.ex07;

import java.net.URL;

public class Exam01 {

  public static void main(String[] args) throws Exception {
    // 웹 상에서 자원의 위치를 표현하는 방법
    // => [protocol]://서버주소:포트번호/자원경로
    // 프로토콜 : http, https, ftp 등
    // 서버주소 : IP 주소, 도메인명
    // 포트번호 : 80(생략가능), 8080(프록시서버) 등
    // 자원경로 : /index.html, /board/list.jsp 등
    // https://
    URL url = new URL("http://bitcamp.co.kr:8080/index.php?main_page=home");

    // URL 분석
    System.out.printf("프로토콜: %s\n", url.getProtocol());
    System.out.printf("서버주소: %s\n", url.getHost());
    System.out.printf("포트번호: %d\n", url.getPort()); // 지정하지 않으면 기본 리턴값 -1
    System.out.printf("자원경로: %s\n", url.getPath());

  }

}


