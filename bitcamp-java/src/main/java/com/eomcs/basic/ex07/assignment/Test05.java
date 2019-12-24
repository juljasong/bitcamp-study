package com.eomcs.basic.ex07.assignment;

import java.util.Scanner;

// 과제: 재귀호출을 이용하여 직삼각형을 출력하라.
// 실행)
// 밑변의 길이? 5
// *
// **
// ***
// ****
// *****

public class Test05 {

  static int base;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("밑변의 길이? "); // 사용자로부터 밑변의 길이를 입력 받는다.
    base = sc.nextInt();
    sc.close();

    printTriangle(base); // 직삼각형을 출력한다.
  }

  static void printTriangle(int base) {
    if (base == 0) 
      return;

    printTriangle(base - 1);

    for (int i = 0 ; i < base ; i++)
      System.out.print("*");

    System.out.println();
  }
}
