// final : 파라미터

package com.eomcs.oop.ex06.e;

public final class Exam0320 {

  public void m1(final int a) {
    // 파라미터는 메서드가 호출될 때 외부의 값을 받는 용도
    // 메서드 안에서 파라미터 값을 임의로 변경하게 되면
    // 처음 받은 파라미터 값을 사용하지 못하는 상황 발생
    // -> 파라미터의 잘못된 사용 방지하고자 보통 파라미터를 final로 선언

    // a = 200;
  }

}
