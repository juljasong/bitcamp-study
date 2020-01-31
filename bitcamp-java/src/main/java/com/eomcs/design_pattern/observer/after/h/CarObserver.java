package com.eomcs.design_pattern.observer.after.h;

public interface CarObserver {

  // 자동차의 시동이 걸렸을 때 호출할 메서드
  // => 보통 메서드의 이름은 동사로 시작하는데,
  // 옵저버에게 통지할 때 호출하는 메서드는
  // 명사구의 상태 이름으로 정의할 수 있다.

  // 자동차 시동 켤 때
  void carStarted();

  // 자동차 시동 끌 때
  void carStopped();

}
