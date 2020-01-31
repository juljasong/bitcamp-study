package com.eomcs.design_pattern.observer.after.g;

public class Test01 {

  // Car 클래스
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

  }

}


