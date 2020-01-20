// 상수를 그룹 별로 클래스로 묶어 별도의 클래스로 분리하여 다루기
package com.eomcs.oop.ex11.c.step6;

import static com.eomcs.oop.ex11.c.step6.Appliance.TV;
import static com.eomcs.oop.ex11.c.step6.Computer.RAM;
import static com.eomcs.oop.ex11.c.step6.Book.NOVEL;

public class Exam0110 {
  public static void main(String[] args) {
    Product p = new Product();
    p.category = TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;
    
    Product p2 = new Product();
    p.category = RAM; // 컴퓨터/RAM
    p.name = "삼성 모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = NOVEL; // 책/소설
    p.name = "토지";
    p.price = 18000;
    p.category = Book.ESSAY;
    p.category = Computer.MOUSE;
  }
}

// 각각의 상수를 별도의 클래스로 묶어 관리하는 것은 좋으나,
// 자잘한 클래스들을 별도의 파일로 분리하여 패키지 멤버 클래스로 정의하니까
// 관리하기가 매우 번거롭다.