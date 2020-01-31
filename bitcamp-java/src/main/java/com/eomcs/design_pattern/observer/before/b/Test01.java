package com.eomcs.design_pattern.observer.before.b;

public class Test01 {

  public static void main(String[] args) {
    Car car = new Car();

    car.start();

    car.run();

    car.stop();

    // 프로젝트 완료한 다음 시간이 지난 후
    // 1) 자동차 시동 걸 때 안절벨트 착용 여부 검사 기능 추가

  }

}


