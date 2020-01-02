package com.eomcs.oop.ex03.test;

import com.eomcs.oop.ex03.Engine;

public class Car {
  
  /* new() -> 메모리는 Heap */
  boolean on;
  int speed;
  String model;
  String maker;
  Engine engine;
  int distance;
  
  Car () {
    this.engine = new Engine(4, 16, 1980);
  }

  /* static 메소드는 method area */
  static void start(Car c) {
    c.on = true; // c1.on
  }
  static void stop(Car c) {
    c.on = false;
  }
  
  /* non-static 메소드 */
  void speedUp() {
    this.speed += 10;
  }
  void speedDown() {
    this.speed -= 10;
  }
  
  void check() {
    if(this.engine.oilState == 0) {
      this.engine.cleanOil();
      System.out.println("엔진오일 교체 완료");
    }
    System.out.println("자동차 정비 완료");
  }
  
}

