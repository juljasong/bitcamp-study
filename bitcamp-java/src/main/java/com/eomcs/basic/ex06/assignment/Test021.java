package com.eomcs.basic.ex06.assignment;

public class Test021 {

  public static void main(String[] args) {

    int width = Console.inputInt();

    int i = 0;

    while (i++ < width) {
      Graphic.drawLine(i, '*');
      System.out.println();
    }
    
    i--;

    while (--i > 0) {
      Graphic.drawLine(i, '*');
      System.out.println();
    }
  }
  
}
