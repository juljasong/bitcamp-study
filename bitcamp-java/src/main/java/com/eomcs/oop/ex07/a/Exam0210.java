/* 캡슐화 사용 후 - 특정 필드 직접 접근 금지 */

package com.eomcs.oop.ex07.a;

class Score3 {
  String name;
  int kor;
  int eng;
  int math;
  
  // 연산 결과의 보호를 위해 필드나 메서드 외부 접근 범위를 조정하는 문법 : 캡슐화(Encapsulation)
  private int sum; // private 변수에 접근하기 위해 getter 필요
  private float avg;
  
  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.avg = this.sum / 3f;
  }
  
  int getSum() { // getter
    return this.sum;
  }
  
  float getAvg() {
    return this.avg;
  }
}

public class Exam0210 {
  public static void main(String[] args) {
    Score3 s1 = new Score3();
    
    s1.name = "피에르";
    s1.eng = 100;
    s1.kor = 90;
    s1.math = 80;
    
    s1.compute();
    
    // s1.sum = 300;
    // s1.avg = 100f;
    
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.getSum(), s1.getAvg());

    
  }

}

