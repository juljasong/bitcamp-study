package com.eomcs.lms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.ComponentScan;


// Spring IoC 컨테이너가 탐색할 패키지 설정

@ComponentScan(value = "com.eomcs.lms") // 지정 패키지와 하위 패키지에서 @Component가 붙은 클래스 찾아 객체 생성.
public class AppConfig {

  static Logger logger = LogManager.getLogger(AppConfig.class);

  public AppConfig() {
    AppConfig.logger.info("AppConfig 객체 생성!");
  }

}
