// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0313 {

  static interface Player {
    void play();
  }

  static void testPlayer(Player p) {
    p.play();
  }

  public static void main(String[] args) {
    // lambda
    testPlayer(() -> System.out.println("Test Player"));
  }
}


