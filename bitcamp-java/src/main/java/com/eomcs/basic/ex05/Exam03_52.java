// 비트 연산자
package com.eomcs.basic.ex05;

public class Exam03_52 {
    public static void main(String[] args) {
      // % 이용하여 짝/홀 알아내기
      System.out.println(57 % 2 == 0 ? "짝수" : "홀수");
      System.out.println((57 & 0x1) == 0 ? "짝수" : "홀수");
    }
}
