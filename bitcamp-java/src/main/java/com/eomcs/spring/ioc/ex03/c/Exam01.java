// 생성자 파라미터 값 지정 II
package com.eomcs.spring.ioc.ex03.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex03/d/application-context.xml");

  }

}


