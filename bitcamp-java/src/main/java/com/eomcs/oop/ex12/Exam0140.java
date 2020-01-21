// 람다(lambda) - parameter
package com.eomcs.oop.ex12;

public class Exam0140 {

  static interface Player {
    void play(String name, int age);
  }


  public static void main(String[] args) {

    // 2. 파라미터 2개일 때 () 생략 불가

    Player p = (name, age) -> System.out
        .println("Hi, my name is " + name + ", and i'm " + age + " years old.");
    p.play("중딩", 15);
    p.play("대딩", 21);

  }

}


