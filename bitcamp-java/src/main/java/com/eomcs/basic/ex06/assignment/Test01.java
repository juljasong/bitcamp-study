package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {

    int width = inputInt();

    int line = 0;
    while (line++ < width) {
      drawLine(line);
      System.out.println();
    }
  }

  static int inputInt() {
    Scanner sc = new Scanner(System.in);
    System.out.print("밑변 길이? ");
    int width = sc.nextInt();
    sc.close();
    return width;
  }

  static void drawLine(int line) {
    int j = 0;
    while (j++ < line) {
      System.out.print("*");
    } 
    j = 0;
  }
  
}
