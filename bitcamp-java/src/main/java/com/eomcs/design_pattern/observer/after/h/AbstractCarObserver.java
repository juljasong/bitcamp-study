package com.eomcs.design_pattern.observer.after.h;

// 인터페이스 구현체가 메서드를 정의하기 쉽도록 이 클래스에서 미리 모든(또는 일부) 메서드를 구현하였다.
// 인터페이스 구현체가 메서드를 정의하기 쉽도록 미리 구현된 메서드 상속해줌
public class AbstractCarObserver implements CarObserver {

  @Override
  public void carStarted() {}

  @Override
  public void carStopped() {}

}
