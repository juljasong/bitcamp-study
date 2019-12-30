package com.eomcs.oop.ex03.test;

import com.eomcs.oop.ex03.test.sub.A;

class Score { // 패키지 멤버 클래스
  /* 생성자 */
  Score () { 
    System.out.println("생승자");
  }
  
  Score (String name, int kor, int eng, int math) {
    System.out.println("생승자2");
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
    Score.increase();
  }
  
  static int count = 0;
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  static void increase() {
    Score.count++;
  }
  
  void compute() {
    this.sum = this.eng + this.kor + this.math; // this -> 멤버 변수
    this.aver = this.sum / 3f;
  }
}

public class Test01 {
  

  public static void main(String[] args) {
    A obj = new A();
    
    System.out.println("=======");
    Score julia = new Score();
    julia.name = "송율리아";
    julia.kor = 100;
    julia.eng = 90;
    julia.math = 80;
    julia.compute();
    Score.increase();
    
    System.out.println("=======");
    Score dayeong = new Score();
    dayeong.name = "다영";
    dayeong.kor = 90;
    dayeong.eng = 80;
    dayeong.math = 70;
    dayeong.compute();
    Score.increase();
  }

}
