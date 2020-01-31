package com.eomcs.design_pattern.observer.after.d;

public class Test01 {

  public static void main(String[] args) {
    Car car = new Car();
    car.addCarObserver(new SafeBeltCarObserver());
    car.addCarObserver(new EngineOilCarObserver());
    car.addCarObserver(new BreakOilCarObserver());

    car.start();

    car.run();

    car.stop();


    // 3) 자동차 시동 걸 때 브레이크 오일 검사 기능을 추가한다.

  }

}


