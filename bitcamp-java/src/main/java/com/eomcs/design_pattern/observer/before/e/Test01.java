package com.eomcs.design_pattern.observer.before.e;

public class Test01 {

  public static void main(String[] args) {
    Car car = new Car();

    car.start();

    car.run();

    car.stop();


    // 4) 시동 끌 때 자동차 전조등을 자동으로 끄는 기능을 추가한다.

  }

}

