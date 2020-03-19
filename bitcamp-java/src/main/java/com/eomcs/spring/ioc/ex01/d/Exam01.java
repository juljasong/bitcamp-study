// Ioc컨테이너에 보관된 객체 꺼내기
package com.eomcs.spring.ioc.ex01.d;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam01 {
  public static void main(String[] args) {

    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex01/d/application-context.xml");

    // 현재 IoC 컨테이너에 들어 있는 객체 출력

    SpringUtils.printBeanList(iocContainer);

    System.out.println("실행 완료!");
  }
}


