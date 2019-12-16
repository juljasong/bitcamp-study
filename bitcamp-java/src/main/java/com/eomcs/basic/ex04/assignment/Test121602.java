package com.eomcs.basic.ex04.assignment;

import java.util.Scanner;

public class Test121602 {

  public static void main(String[] args) {

    int min = 1000000000;
    int max = -1000000000;
    int[] num = new int[5];
    
    Scanner sc = new Scanner(System.in);
    System.out.print("입력(숫자 5자리)? ");
    for(int i = 0 ; i < num.length ; i++) {
     num[i] = sc.nextInt();
    }
    sc.close();
    
    for ( int i = 0 ; i < num.length ; i++) {
      if (max < num[i])
        max = num[i];
    }
    
    for ( int i = 0 ; i < num.length ; i++) {
      if (min > num [i])
        min = num[i];
    }
    
    System.out.println("최소값 : " + min);
    System.out.println("최대값 : " + max);
  }
}
