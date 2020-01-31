package com.eomcs.design_pattern.observer.after.g;

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

  private void notifyObserversOnStarted() {
    for (CarObserver observer : observers) {
      observer.carStarted();
    }
  }

  private void notifyObserversOnStopped() {
    for (CarObserver observer : observers) {
      observer.carStopped();
    }
  }

  public void start() {
    System.out.println("시동을 건다.");
    // 자동차에 시동 걸면, 등록된 관찰자들에 알린다.
    notifyObserversOnStarted();
  }

  public void run() {
    System.out.println("달린다.");

  }

  public void stop() {
    System.out.println("시동을 끈다.");
    notifyObserversOnStopped();
  }

}


