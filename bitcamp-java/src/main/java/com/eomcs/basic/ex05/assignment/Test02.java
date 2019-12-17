package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

public class Test02 {

  public static void main(String[] args) {

    int[] num = new int[5];

    Scanner sc = new Scanner(System.in);
    System.out.print("입력(숫자 5개)? ");
    for(int i = 0 ; i < num.length ; i++) {
      num[i] = sc.nextInt();
    }
    sc.close();

    int min = num[0],  max = num[0];
    
    for (int i = 1 ; i < num.length ; i++) {
      if (max < num[i])
        max = num[i];
      else if (min > num[i])
        min = num[i];
    }


    System.out.println("최소값 : " + min);
    System.out.println("최대값 : " + max);
  }
}
