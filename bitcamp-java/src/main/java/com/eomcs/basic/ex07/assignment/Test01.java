package com.eomcs.basic.ex07.assignment;

public class Test01 {
  public static void main(String[] args) {
    // 배열의 값 중에서 최대 값을 출력하라.
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};

    int value = max(values);

    System.out.println(value);
    // 출력결과:
    // 78
  }

  static int max(int[] values) {
    int max = values[0];
    for (int i = 1 ; i < values.length ; i++) {
      max = max > values[i] ? max : values[i];
    }
    return max;
  }
}