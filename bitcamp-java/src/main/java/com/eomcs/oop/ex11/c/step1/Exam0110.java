// 상수 활용 전
package com.eomcs.oop.ex11.c.step1;

public class Exam0110 {
  public static void main(String[] args) {
    Product p = new Product();
    p.category = 10; // 가전/TV
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p.category = 3; // 컴퓨터/RAM
    p.name = "삼성 모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = 101; // 책/소설
    p.name = "토지";
    p.price = 18000;

    // 제품의 카테고리는 정수 값으로 설정
    // 각 카테고리에 대해 정수 값을 지정해 놓고 입력할 때 사용.
    // But, 코드를 보는 것만으로 어떤 카테고리인지 알 수 없어 보통 주석을 붙인다.
  }
}


