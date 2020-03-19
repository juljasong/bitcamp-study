// 프로퍼티에 객체 주입하기
package com.eomcs.spring.ioc.ex04.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam01 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex04/c/application-context.xml");

    // 프로퍼티 타입이 int인 경우 xml에 작성한 문자열이 자동으로 int값으로 형변환
    // 형변환 할 수 없을 땐 Exception 발생
    // 자동 형변환은 primitive type에 대해서만 가능-> 형변환 하기 위해서는 형변환 시키는 클래스를 만들어 등록해야 함


    System.out.println(iocContainer.getBean("c1"));
    System.out.println(iocContainer.getBean("c2"));

    System.out.println(iocContainer.getBean("e1"));
    System.out.println(iocContainer.getBean("e2"));
  }

}


