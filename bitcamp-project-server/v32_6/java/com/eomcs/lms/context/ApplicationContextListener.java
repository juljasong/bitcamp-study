package com.eomcs.lms.context;

import java.util.Map;

// 애플리케이션 상태가 변경되었을 때 호출할 메서드 규칙 정의
// => Observer(Listener) 규칙 정의

public interface ApplicationContextListener {

  // 앱 실행 시 호출
  void contextInitialized(Map<String, Object> context);
  // 호출자가 옵저버의 실행결과를 받을 수 있도록 파라미터로 맵 객체를 전달할 것이다
  // 리턴 값으로 결과를 전달하지 않고 파라미터로 넘어온 저장소에 보관한다
  // => 파라미터 방식은 메서드에게 작업에 필요한 정보에 대해 in/out 둘 다 가능쓰

  // 앱 종료 시 호출
  void contextDestroyed(Map<String, Object> context);

}
