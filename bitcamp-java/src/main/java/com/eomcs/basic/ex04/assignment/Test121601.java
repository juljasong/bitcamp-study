package com.eomcs.basic.ex04.assignment;

import java.util.Scanner;

public class Test121601 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("입력 ? ");
    int a = sc.nextInt();
    int b = sc.nextInt();
    sc.close();
    int sum = 0;
    
    for ( int i = a ; i <= b ; i++) {
      sum += i;
    }
    System.out.printf("%d에서 %d까지의 합은 %d 입니다.", a, b, sum);

  }

}
