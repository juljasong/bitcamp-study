// static 멤버 import : 특정 클래스의 static 멤버를 클래스 이름 없이 사용하고 싶을 때
package com.eomcs.oop.ex11.c.step5;

import static com.eomcs.oop.ex11.c.step5.Category.*;

public class Exam0120 {
  public static void main(String[] args) {
    Product p = new Product();
    p.category = APPLIANCE_TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p.category = COMPUTER_RAM; // 컴퓨터/RAM
    p.name = "삼성 모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = BOOK_NOVEL; // 책/소설
    p.name = "토지";
    p.price = 18000;
  }
}
