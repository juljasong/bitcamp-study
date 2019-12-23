package com.eomcs.basic.ex07;

//# 메서드 : 스택 메모리 응용 III - 스택 오버플로우
//
public class Exam0462 {

  static int sum(int value) {
    // 종료 조건을 빼버리면, 무한으로 호출한다.

    if (value == 1)
      return 1;
    else 
      return value + sum(value - 1);
    // long a1, a2, a3, a4, a5, a6, a7, a8, a9;
    //long a11, a12, a13, a14, a15, a16, a17, a18, a19;
    //long a111, a112, a113, a114, a115, a116, a117, a118, a119;
    //System.out.println(value);

  }

  public static void main(String[] args) {
    // 호출하는 메서드의 로컬 변수가 클 때는 스택 메모리가 빨리 찬다.
    // => 즉 스택 오버플로우는 메서드 호출 회수에 영향 받는것이 아닌 메서드에서 생성하는 로컬 변수의 크기에 영향을 받음
    System.out.println(sum(1000));
  }
}