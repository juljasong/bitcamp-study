package com.eomcs.basic.ex07.assignment;

public class Test03 {
  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22}; // 0~8

    // 배열의 들어 있는 값의 순서를 꺼꾸로 바꿔라. 
    reverse(values); 
    
    for (int value : values) {
      System.out.println(value);
    }
    // 출력결과:
    // -22, 0, 45, 22, 12, 78, -3, 4, 34
  }

  private static void reverse(int[] values) {
    int temp = 0;
    int valuesIndex = values.length-1;
    for (int i = 0 ; i < (values.length)/2 ; i++) {
      temp = values[i];
      values[i] = values[valuesIndex-i];
      values[valuesIndex-i] = temp;
    }
  }
}
