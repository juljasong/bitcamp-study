// final : 오버라이딩 불가

package com.eomcs.oop.ex06.e;

public class Exam0140 extends Exam0130 {
  // 메서드에 final 붙이면 서브 클래스에서 오버라이딩 불가
  /*
   * public void m1() { // final 메서드 오버라이딩 불가 }
   */
  @Override
  public void m2() {
    // 얜 가능
  }

}
