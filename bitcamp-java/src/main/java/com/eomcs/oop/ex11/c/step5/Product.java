package com.eomcs.oop.ex11.c.step5;

public class Product {
  // 카테고리 상수가 많을 경우 별도의 클래스로 분리하여 관리하기에 좋다
  // Product에 정의되었던 상수를 Category로 분리
  int category;
  String name;
  String maker;
  int price;
}
