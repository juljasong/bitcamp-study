// Ioc컨테이너에서 객체 꺼내기
package com.eomcs.spring.ioc.ex01.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam02 {
  public static void main(String[] args) {

    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex01/g/application-context.xml");

    // 현재 IoC 컨테이너에 들어 있는 객체 출력

    SpringUtils.printBeanList(iocContainer);

    // 1) 존재하지 않는 객체 꺼내기
    System.out.println(iocContainer.getBean("c2"));
    // null이 아닌 Exception 발생

    System.out.println("실행 완료!");
  }
}


