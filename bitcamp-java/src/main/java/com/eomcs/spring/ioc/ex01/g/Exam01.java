// Ioc컨테이너에서 객체 꺼내기
package com.eomcs.spring.ioc.ex01.g;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;
import com.eomcs.spring.ioc.ex01.Car;

public class Exam01 {
  public static void main(String[] args) {

    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex01/g/application-context.xml");

    // 현재 IoC 컨테이너에 들어 있는 객체 출력

    SpringUtils.printBeanList(iocContainer);

    // 객체 이름으로 꺼내기
    Car c1 = (Car) iocContainer.getBean("c1");

    // 객체 타입으로 꺼내기
    Car c2 = iocContainer.getBean(Car.class);

    System.out.println(c1 == c2);

    System.out.println("실행 완료!");
  }
}


