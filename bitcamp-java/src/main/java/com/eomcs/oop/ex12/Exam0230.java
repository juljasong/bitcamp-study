// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0230 {

  static interface Player {
    void play();

    void stpo();
  }


  public static void main(String[] args) {
    // 추상 메서드 두 개는 안됨 ㅎ

    Player p1 = () -> System.out.println("실행");
    p1.play();

  }
}


