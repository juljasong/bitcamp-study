package com.eomcs.design_pattern.observer.after.f;

public class SunroofCarObserver implements CarObserver {

  @Override
  public void carStarted() {}

  @Override
  public void carStopped() {
    System.out.println("썬루프 닫는다");

  }

}
