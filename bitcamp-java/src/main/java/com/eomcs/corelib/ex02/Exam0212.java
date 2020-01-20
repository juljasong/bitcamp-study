// Wrapper 클래스 - 종류
package com.eomcs.corelib.ex02;

public class Exam0212 {
  public static void main(String[] args) {

    Integer i = new Integer(3000000);
    Integer i2 = new Integer(3000000);
    System.out.println(i == i2); // false

    Integer i3 = Integer.valueOf(3000000);
    Integer i4 = Integer.valueOf(3000000);
    System.out.println(i3 == i4); // false

  }
}


