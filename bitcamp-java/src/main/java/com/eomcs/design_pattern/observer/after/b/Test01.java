package com.eomcs.design_pattern.observer.after.b;

public class Test01 {

  public static void main(String[] args) {

    Car car = new Car();
    car.addCarObserver(new SafeBeltCarObserver());

    car.start();

    car.run();

    car.stop();

    // SafeBeltCarObserver : 자동차 시동 걸릴 때 보고 받을 객체
    // 시동걸 때 수행할 기능 정의
    // => carStarted()
    // -> Car 객체에 관찰자 등록
  }

}


