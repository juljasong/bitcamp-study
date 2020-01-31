package com.eomcs.design_pattern.observer.after.f;

public class Test01 {

  public static void main(String[] args) {
    Car car = new Car();
    car.addCarObserver(new SafeBeltCarObserver());
    car.addCarObserver(new EngineOilCarObserver());
    car.addCarObserver(new BreakOilCarObserver());
    car.addCarObserver(new LightOffCarObserver());
    car.addCarObserver(new SunroofCarObserver());

    car.start();

    car.run();

    car.stop();

    // 5) 시동 끌 때 썬루프를 자동으로 닫기
  }

}


