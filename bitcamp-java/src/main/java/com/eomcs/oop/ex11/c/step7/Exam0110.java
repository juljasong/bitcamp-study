// 상수 코드를 스태틱 중첩 클래스로 다루기
package com.eomcs.oop.ex11.c.step7;

public class Exam0110 {
  public static void main(String[] args) {

    // OGNL (Object Graph Navigation Language)
    // => 자바에서 객체 안에 있는 필드를 가리킬 때 . 를 이용하여 표기하는 방법
    // 객체 안에 객체가 계층적으로 들어있을 때, 파일 경로를 가리키듯 .을 이용하여 가리킬 수 있음
    // ex) 객체, 필드, 필드, 필드 = 1900;
    Product p = new Product();
    p.category = Category.appliance.TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p.category = Category.computer.RAM;
    p.name = "삼성 모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = Category.book.NOVEL;
    p.name = "토지";
    p.price = 18000;
  }

}
