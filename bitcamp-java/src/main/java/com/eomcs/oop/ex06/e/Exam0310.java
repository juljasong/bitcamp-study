// final : 로컬 변수

package com.eomcs.oop.ex06.e;

public final class Exam0310 {
  
  public void m1() {
    // 로컬 변수에 final을 붙이면 값을 변경할 수 없는 상수로 사용
    final int a = 100;
    //a = 200;
    
    final int b;
    b = 200;
    // 이건 가능
  }

}
