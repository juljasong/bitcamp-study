package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

public class Test012 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("입력 ? ");
    int start = sc.nextInt();
    int temp = start;
    int end = sc.nextInt();
    sc.close();
    int sum = 0;

    if ( end > start ) {
      for ( int i = start ; i <= end ; i++) {
        sum += i;
      }
    } else {
      for (int i = end ; i <= start ; i++) {
        sum += i;
      }
    }
    /*
    while (temp <= end) {
      sum += temp;
      temp++;
    }
    */
    System.out.printf("%d에서 %d까지의 합은 %d 입니다.", start, end, sum);
  }
}
