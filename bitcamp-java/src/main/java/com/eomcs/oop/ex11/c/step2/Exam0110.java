// 상수 활용 전 : 카테고리를 문자열로 받기
package com.eomcs.oop.ex11.c.step2;

public class Exam0110 {
  public static void main(String[] args) {
    // 이전 예제에서는 카테고리를 숫자로 받아 해당 카테고리가 무엇인지 알 수 없었다.
    // 그냥 문자열로 받으면?
    Product p = new Product();
    p.category = "appliance/tv"; // 가전/TV
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p.category = "computer/ram"; // 컴퓨터/RAM
    p.name = "삼성 모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = "book/novel"; // 책/소설
    p.name = "토지";
    p.price = 18000;

    // 카테고리를 문자열로 다루면 주석을 달 필요가 없지만, 오타가 들어갈 경우가 생길 수 있다.

    //
  }
}


