package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test031 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("밑변 길이? ");
    int width = sc.nextInt();
    sc.close();
    
    if (width % 2 == 0) {
      width--;
    }
    
    int spaceSize = width >> 1;
    int line = 0;
    
    while (line++ < width) {
      if (line % 2 == 0) {
        continue;
      }
      
      int count = 0;
      while (count++ < spaceSize) {
        System.out.print(" ");
      }
      spaceSize--;
      
      int x = 0;
      while (x++ < line) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
