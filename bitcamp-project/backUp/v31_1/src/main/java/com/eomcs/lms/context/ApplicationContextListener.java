package com.eomcs.lms.context;

// 애플리케이션 상태가 변경되었을 때 호출할 메서드 규칙 정의
// => Observer(Listener) 규칙 정의

public interface ApplicationContextListener {

  // 앱 실행 시 호출
  void contextInitailized();

  // 앱 종료 시 호출
  void contextDestroyed();

}
