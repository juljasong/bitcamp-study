package com.eomcs.design_pattern.observer.after.c;

public class Test01 {

  public static void main(String[] args) {
    Car car = new Car();
    car.addCarObserver(new SafeBeltCarObserver());
    car.addCarObserver(new EngineOilCarObserver());

    car.start();

    car.run();

    car.stop();


    // 2) 자동차 시동 걸 때 엔진 오일 검사 기능을 추가하는 CarObserver 추가

  }

}


