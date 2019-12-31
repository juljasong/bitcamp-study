/* 캡슐화 사용 후 - 필드 값 변경 시 특정 작업 수행하게 하기 */

package com.eomcs.oop.ex07.a;

class Score4 {
  String name;

  // 점수 변경 시 자동으로 합계/평균 계산해야 할 때 => 값을 변경 할 때 메소드를 통해 값을 설정
  private int kor;
  private int eng;
  private int math;

  // 필드 값 설정하는 메소드 : setField -> public! setter 
  // 필드를 private로 막으면 값을 조회할 수 없기 때문에 getter 추가해야함

  public int getKor() {
    return this.kor;
  }
  public void setKor(int kor) {
    this.kor = kor;
    this.compute();
  }

  public int getEng() {
    return this.eng;
  }
  public void setEng(int eng) {
    this.eng = eng;
    this.compute();
  }

  public int getMath() {
    return this.math;
  }
  public void setMath(int math) {
    this.math = math;
    this.compute();
  }

  private int sum; 
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

public class Exam0310 {
  public static void main(String[] args) {
    Score4 s1 = new Score4();

    s1.name = "피에르";
    s1.setKor(100);
    s1.setEng(90);
    s1.setMath(80);

    //s1.compute();

    s1.setEng(100);
    s1.setMath(100);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.getKor(), s1.getEng(), s1.getMath(), s1.getSum(), s1.getAvg());


  }

}

