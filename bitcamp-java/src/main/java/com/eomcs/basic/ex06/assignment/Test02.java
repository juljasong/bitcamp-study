package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test02 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("밑변 길이? ");
    int a = sc.nextInt();
    sc.close();
    
    int i = 0;
    int j = 0;
    
    while (i < a) {
      while (j <= i) {
        System.out.print("*");
        j++;
      } 
      System.out.println();
      i++;
      j = 0;
    }
    i = 0;
    
    while (i < a-1) {
      while (j < a-i-1) {
        System.out.print("*");
        j++;
      } 
      System.out.println();
      i++;
      j = 0;
    }
  }
}
