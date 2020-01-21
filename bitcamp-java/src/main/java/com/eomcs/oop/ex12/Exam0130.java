// 람다(lambda) - parameter
package com.eomcs.oop.ex12;

public class Exam0130 {

  static interface Player {
    void play(String name);
  }


  public static void main(String[] args) {

    // 2. 파라미터 1개일 때 () 생략 가능

    Player p = name -> System.out.println(name + ", Hello~");
    p.play("p1");
    p.play("p2");

  }

}


