package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Console {

  @Deprecated
  static int inputInt() {
    System.out.print("밑변 길이? ");
    Scanner sc = new Scanner(System.in);
    int width = sc.nextInt();
    sc.close();
    return width;
  }
  
  static int inputInt(String message) {
    System.out.print(message);
    Scanner sc = new Scanner(System.in);
    int width = sc.nextInt();
    sc.close();
    return width;
  }
  
}
