// 프로퍼티 호출 - 객체 주입 시 객체 생성 순서
package com.eomcs.spring.ioc.ex04.d;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex04/d/application-context.xml");

    // 프로퍼티 값 주입 시:
    // 1) 의존 객체 생성되지 않은 상태라면, 의존 객체 먼저 생성한 후 프로퍼티 값 주입한다.
    // 2) 의존 객체 생성된 상태라면, 그대로 프로퍼티 값 주입.

    System.out.println("------------------");
    System.out.println(iocContainer.getBean("c1"));
  }

}


