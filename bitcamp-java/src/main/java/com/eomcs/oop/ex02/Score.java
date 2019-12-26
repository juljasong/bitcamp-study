package com.eomcs.oop.ex02;

//# 사용자 정의 데이터 타입 - 인스턴스 변수
// => 학생의 성적 데이터를 담을 메모리를 설계한다.
//
public class Score {
  // 인스턴스 변수
  // => new 명령으로 생성되는 변수이다.
  // => 데이터를 개별적으로 다루고 싶을 때 인스턴스 변수로 선언한다.
  //    즉 new 명령을 사용하면 여러 명의 학생 성적 데이터를 개별적으로 다룰 수 있도록
  //    메모리를 생성할 수 있다.
  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;
  
  // 메서드를 통해 값을 계산하는 기능 추가 => 연산자 정의
  // 합계와 평균 계산하는 기능 추가
  public void Calc() {
    // => 메서드를 다음과 같이 호출할 때, instance_address.method.name();
    // "인스턴스 메서드"로 인스턴스 주소를 자동으로 받아온다.
    // 인스턴스 메서드는 static을 붙이지 않는다.
    // 메서드를 호출할 때 넘겨준 인스턴스 주소는 내장 변수 this에 자동 보관.
    // => 인스턴스 메서드는 인스턴스 주소 없이 호출 불가, But 파라미터로 인자 받을 필요 없음
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
    // 인스턴스 메서드는 인스턴스 주소를 받는 내장 변수(built-in)가 있다. 
    // 그 변수의 이름은 this이다.
  }
  
  public static void calculate(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = s.sum / 3f;
  }
}
