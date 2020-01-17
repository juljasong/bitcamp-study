// final : 오버라이딩 불가

package com.eomcs.oop.ex06.e;

public class Exam0130 {
  // 메서드에 final 붙이면 서브 클래스에서 오버라이딩 불가
  public final void m1() {
    // 서브 클래스에서 변경할 수 없는 메서드
    // > 보안 관련 메서드, 템플릿 메서드 디자인 패턴 처럼 전체적인 작업 흐름 정의한 메서드
  }

  public void m2() {

  }

}
