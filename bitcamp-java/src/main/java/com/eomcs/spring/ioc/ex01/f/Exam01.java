// 스프링 IoC 컨테이너 사용
package com.eomcs.spring.ioc.ex01.f;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {
  public static void main(String[] args) {

    // 3) 자바 클래스 파일의 애노테이션으로부터 설정 정보를 추출한다.
    // 자바 클래스로 정보를 다루는 것을 java config 라 부른다.
    // => 생성자에 설정 정보를 갖고 있는 클래스의 타입 정보를 넘긴다.
    ApplicationContext iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    SpringUtils.printBeanList(iocContainer);

    System.out.println("실행 완료!");
  }
}


