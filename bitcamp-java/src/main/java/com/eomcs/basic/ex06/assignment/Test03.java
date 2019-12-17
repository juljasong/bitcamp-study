package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Test03 {

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("밑변 길이? ");
    int a = sc.nextInt();
    sc.close();
    
    int i = 0;
    int j = 0;
    
    while (i < a/2+1) { // 밑 변 a가 5일 때, a/2+1= 3줄 
      
      while (j < a/2-i) { // 
        System.out.print(" ");
        j++;
      }
      i++;
      while (j < a/2+i) { // j 이어서 ...
        System.out.print("*");
        j++;
      }
      
      //j = 0;
      System.out.println();
    }

  }

}
