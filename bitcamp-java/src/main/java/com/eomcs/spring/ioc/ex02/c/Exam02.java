// 빈 생성 정책
package com.eomcs.spring.ioc.ex02.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.ex02.Car;

public class Exam02 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex02/c/application-context.xml");

    Car obj1 = (Car) iocContainer.getBean("c1");
    Car obj2 = (Car) iocContainer.getBean("c1");
    Car obj3 = (Car) iocContainer.getBean("c1");

    System.out.println(obj1 == obj2);
    System.out.println(obj1 == obj3);


  }

}


