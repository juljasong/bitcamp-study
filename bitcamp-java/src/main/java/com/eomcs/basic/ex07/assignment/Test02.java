package com.eomcs.basic.ex07.assignment;

public class Test02 {
  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};

    // 배열에 들어 있는 값을 오름차순으로 정렬하라.
    sort(values); 

    for (int value : values) {
      System.out.println(value);
    }
    // 출력결과:
    // -22, -3, 0, 4, 12, 22, 34, 45, 78
  }

  private static void sort(int[] values) {
    int temp = 0;
    int i;
    
    for(i = 0 ; i < values.length-1 ; i++) {
      int min = Integer.MAX_VALUE;
      for(int j = i ; j < values.length ; j++) { 
        if (min > values[j]) {
          min = values[j];
          
          temp = values[i];
          values[i] = min;
          values[j] = temp;
        }
      }
    }
  }

}
