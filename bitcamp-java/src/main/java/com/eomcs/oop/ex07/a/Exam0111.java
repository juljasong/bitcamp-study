/* 캡슐화 사용 전 - 클래스를 작성한 사람의 의도대로 정상 사용할 때 */

package com.eomcs.oop.ex07.a;

class Score2 {
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float avg;
  
  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.avg = this.sum / 3f;
  }
  
}

public class Exam0111 {
  public static void main(String[] args) {
    Score2 s1 = new Score2();
    
    s1.name = "피에르";
    s1.eng = 100;
    s1.kor = 90;
    s1.math = 80;
    
    s1.compute();
    
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.avg);
  }

}
