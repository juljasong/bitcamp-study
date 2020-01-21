// 람다(lambda)
package com.eomcs.oop.ex12;

public class Exam0240 {

  public abstract class Player {
    public abstract void play();
  }


  public static void main(String[] args) {

    // 추상 클래스 안되고 인터페이스만 됨.

    Player p1 = () -> System.out.println("실행");
    p1.play();

  }
}


