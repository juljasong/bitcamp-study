package com.eomcs.spring.ioc.ex01.f;

import org.springframework.context.annotation.Bean;
import com.eomcs.spring.ioc.ex01.Car;

// 클래스 선언부에 annotation으로 스프링 설정 정보 지정
public class AppConfig {
  // 객체 생성

  @Bean
  public Car c1() {
    return new Car();
  }


}
