package com.eomcs.basic.ex05.assignment;

import java.util.Scanner;

public class Test024 {
  public static void main(String[] args) {

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    
    Scanner sc = new Scanner(System.in);
    System.out.print("입력(숫자 5자리)? ");
    
    while (true) {
      int num = sc.nextInt(); // 0이 들어오면 멈춤. 0을 값으로 넣을 수 없다는게 함정
      if (num == 0)
        break;
      min = num < min ? num : min;
      max = num > max ? num : max;
    } 
    sc.close();
    
    System.out.println("최소값 : " + min);
    System.out.println("최대값 : " + max);
  }
}
