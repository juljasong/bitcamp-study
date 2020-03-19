// 프로퍼티 값 확인
package com.eomcs.spring.ioc.ex04.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam02 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex04/a/application-context.xml");

    // 객체가 생성될 떄 생성자와 세터가 호출되는 것 확인
    System.out.println(iocContainer.getBean("c1"));
    System.out.println(iocContainer.getBean("c2"));
    System.out.println(iocContainer.getBean("c3"));
    System.out.println(iocContainer.getBean("c4"));
  }

}


