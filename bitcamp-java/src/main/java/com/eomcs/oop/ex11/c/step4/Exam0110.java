// 상수 활용 후 :
package com.eomcs.oop.ex11.c.step4;

// 정수로 카테고리 값을 정의하면
// 메모리 절약, 주석 달 필요 X

public class Exam0110 {
  public static void main(String[] args) {
    Product p = new Product();
    p.category = Product.APPLIANCE_TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p.category = Product.COMPUTER_RAM; // 컴퓨터/RAM
    p.name = "삼성 모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = Product.BOOK_NOVEL; // 책/소설
    p.name = "토지";
    p.price = 18000;
  }
}
