// 상수 활용 전 : 카테고리를 문자열로 받기
package com.eomcs.oop.ex11.c.step3;

public class Exam0110 {
  public static void main(String[] args) {

    Product p = new Product();
    p.category = Product.appliance_tv; // 가전/TV
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p.category = Product.computer_ram; // 컴퓨터/RAM
    p.name = "삼성 모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = Product.book_novel; // 책/소설
    p.name = "토지";
    p.price = 18000;

    // 고정된 값은 상수로 정의해놓고 쓰면 코드를 작성할 때 편리함
  }
}


