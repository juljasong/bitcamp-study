// 메서드 오버로딩(overloading) - 문법 사용 후
package com.eomcs.oop.ex06.b;

public class Exam0120 {
  
  static class Calculator {
    
    // 같은 이름의 메서드를 여러 개 만들 수 없다면, 같은 일을 수행하는 메서드라도 이름을 다르게 해야 한다.
    static int plus(int a, int b) {
      return a + b;
    }
    static int plusi(int a) {
      return a + a;
    }
    static float plus(float a, float b) {
      return a + b;
    }
    
  }
    public static void main(String[] args) {
      
      int r1 = Calculator.plus(100, 200);
      int r2 = Calculator.plusi(100);
      float r3 = Calculator.plus(35.7f, 22.2f);
      System.out.printf("%d %d %.1f", r1, r2, r3); // 300 200 57.9
    }
}

