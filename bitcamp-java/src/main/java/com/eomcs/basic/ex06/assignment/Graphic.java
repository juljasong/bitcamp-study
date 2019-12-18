package com.eomcs.basic.ex06.assignment;

public class Graphic {
  
  static void drawLine(int num, char ch) {
    int x = 0;
    while (x++ < num) {
      System.out.printf("%s", ch);
    }
  }
  
  static void drawLine(int lenth) { // 같은 메소드명, 다른 매개변수 => 오버로딩
    int x = 0;
    while (x++ < lenth) {
      System.out.print("*");
    }
  }
  
}
