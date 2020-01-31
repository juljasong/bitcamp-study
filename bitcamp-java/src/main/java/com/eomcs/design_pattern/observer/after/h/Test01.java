package com.eomcs.design_pattern.observer.after.h;

public class Test01 {

  // CarObserver 구현체 만들 때, 인터페이스에 선언된 모든 메서드를 구현해야 함
  // - SafeBeltCarObserver는 시동 걸 때만 작업을 수행하지만, carStopped() 메서드 또한 빈 채로라도 구현해야한다.

  // => 여러 메서드 중 일부 메서드만 구현하기 위해, 추상 클래스를 사용할 수 있다
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


