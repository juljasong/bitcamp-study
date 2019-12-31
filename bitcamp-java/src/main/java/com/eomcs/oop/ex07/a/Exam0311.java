/* 캡슐화 사용 후 - 캡슐화와 getter/setter */

package com.eomcs.oop.ex07.a;


class Score5 {
  /* 이하 필드 */
  private String name;
  private int kor, eng, math, sum;
  private float avg; // 값을 조회만 해야하는 sum, avg의 경우 getter만 존재
  
  /* 이하 Property */
  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
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

public class Exam0311 {
  public static void main(String[] args) {
    Score5 s1 = new Score5();
    
    s1.setName("피에르");
    s1.setKor(100);
    s1.setEng(90);
    s1.setMath(80);
    
    //s1.compute();
    
    s1.setEng(100);
    s1.setMath(100);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.getName(), s1.getKor(), s1.getEng(), s1.getMath(), s1.getSum(), s1.getAvg());

    
  }

}

