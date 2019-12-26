package com.eomcs.oop.ex02.study;

public class Score {
  // 변수 선언을 통해 메모리 구조 설계 : 인스턴스 변수
  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;
  
  // 메서드를 통해 값을 계산하는 기능 추가 => 연산자 정의
  // 합계와 평균 계산하는 기능 추가
  public static void Calc(Score score) {
    score.sum = score.kor + score.eng + score.math;
    score.aver = score.sum / 3f;
  }
}

