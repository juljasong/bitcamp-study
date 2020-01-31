package com.eomcs.design_pattern.observer.after.c;

public interface CarObserver {

  // 자동차 시동 켤 때
  void carStarted();

  // 자동차 시동 끌 때
  void carStopped();

}
