// 프로퍼티 값 지정하기
package com.eomcs.spring.ioc.ex04.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex04/a/application-context.xml");

    // System.out.println(iocContainer.getBean("c1"));
    // System.out.println(iocContainer.getBean("c2"));
    // System.out.println(iocContainer.getBean("c3"));
    // System.out.println(iocContainer.getBean("c4"));
  }

}


