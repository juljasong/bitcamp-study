// 람다(lambda) - body
package com.eomcs.oop.ex12;

public class Exam0113 {

  static interface Player {
    void play();
  }


  public static void main(String[] args) {

    // 파라미터 없는 경우 () 생략 불가
    Player p1 =  -> System.out.println("p1");
    p1.play();

    Player p2 =  -> {
      System.out.println("p2");
    };
    p2.play();

  }

}


