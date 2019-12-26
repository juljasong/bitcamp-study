package com.eomcs.oop.ex02.study;


public class Test02 {

  public static void main(String[] args) {
    int a = 700, b = 150;
    // 식1 : 2 + 3 - 1 * 7 / 3 = ?
    // 식2 : 3 * 2 + 7 / 4 - 5 = ?
    // 결과를 개별적으로 관리하기 위해서는 non-static 필드로 선언해야 함.
    
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();
    
    c1.plus(2);
    c1.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);
    System.out.printf("결과: %d\n", c1.result);
    
    c2.plus(3);
    c2.multiple(2);
    c2.plus(7);
    c2.divide(4);
    c2.minus(5);
    System.out.printf("결과: %d\n", c2.result);
    //System.out.printf("%d - %d = %d\n", a , b , Calculator.minus(a, b));
    //System.out.printf("%d * %d = %d\n", a , b , Calculator.multiple(a, b));
    //System.out.printf("%d / %d = %d\n", a , b , Calculator.divide(a, b));
    
  }
  
}
