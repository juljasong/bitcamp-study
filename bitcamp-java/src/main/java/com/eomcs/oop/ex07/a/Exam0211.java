/* 캡슐화 사용 후 - 특정 필드 직접 접근 금지 */

package com.eomcs.oop.ex07.a;

public class Exam0211 {
  public static void main(String[] args) {
    Score3 s1 = new Score3();
    
    s1.name = "피에르";
    s1.eng = 100;
    s1.kor = 90;
    s1.math = 80;
    
    s1.compute();
    
    // 국어, 영어, 수학 점수를 변경한 후 compute를 실행시키지 않으면 이전 값으로 계산된 값이 들어가는게 당연
    // => Exam0310.java
    
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.getSum(), s1.getAvg());

  }

}

