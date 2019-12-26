package com.eomcs.oop.ex02.study;

public class Test01 {

  public static void main(String[] args) {
    Score s = new Score();

    s.name = "피에르";
    s.kor = 50;
    s.eng= 90;
    s.math = 30;
    //s.sum = s.kor + s.eng + s.math;
    //s.aver = s.sum / 3f;

    Score.Calc(s);

    System.out.println(s.sum);
    System.out.println(s.aver);
  }
}
