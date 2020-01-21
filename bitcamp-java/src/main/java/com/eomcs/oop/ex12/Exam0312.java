// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0312 {

  static interface Player {
    void play();
  }

  static void testPlayer(Player p) {
    p.play();
  }

  public static void main(String[] args) {

    //
    testPlayer(new Player() {
      @Override
      public void play() {
        System.out.println("Test Player");
      }
    });
  }
}


