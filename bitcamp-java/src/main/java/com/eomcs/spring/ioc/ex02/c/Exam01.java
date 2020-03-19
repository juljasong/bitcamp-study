// 빈 생성 정책
package com.eomcs.spring.ioc.ex02.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex02/c/application-context.xml");

    // IoC컨테이너 생성시, "singleton"객체는 기본으로 생성

    System.out.println("[빈 이름]");
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.println(name);
    }
  }

}


