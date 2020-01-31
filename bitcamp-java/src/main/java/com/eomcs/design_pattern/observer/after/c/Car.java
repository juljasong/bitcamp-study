package com.eomcs.design_pattern.observer.after.c;

import java.util.ArrayList;
import java.util.List;

public class Car {

  List<CarObserver> observers = new ArrayList<>();

  public void addCarObserver(CarObserver observer) {
    observers.add(observer);
  }

  public void removeCarObserver(CarObserver observer) {
    observers.add(observer);
  }

  public void start() {
    System.out.println("시동을 건다.");
    // 자동차에 시동 걸면, 등록된 관찰자들에 알린다.
    for (CarObserver observer : observers) {
      observer.carStarted();
    }
  }

  public void run() {
    System.out.println("달린다.");
  }

  public void stop() {
    System.out.println("시동을 끈다.");
    for (CarObserver observer : observers) {
      observer.carStopped();
    }
  }
}


