package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

public class Test023 {

  public static void main(String[] args) {

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    System.out.print("입력(숫자 5개)? ");
    Scanner sc = new Scanner(System.in);
    for(int i = 0 ; i < 5 ; i++) {
      int num = sc.nextInt();
      // 3 2 1 0 -1 | -1 0 1 2 3 오류
      if (num < min)
        min = num;
      else if (num > max)
        max = num;
       /* 
      min = num < min ? num : min;
      max = num > max ? num : max;
      */
    }
    sc.close();

    System.out.println("최소값 : " + min);
    System.out.println("최대값 : " + max);
  }

}
