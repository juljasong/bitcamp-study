// 빈 생성 정책
package com.eomcs.spring.ioc.ex02.c;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.ex02.Car;

public class Exam03 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex02/c/application-context.xml");

    System.out.println("-----------------------------");
    Car obj1 = (Car) iocContainer.getBean("c1");
    System.out.println("-----------------------------");
    Car obj2 = (Car) iocContainer.getBean("c2");
    System.out.println("-----------------------------");
    Car obj3 = (Car) iocContainer.getBean("c3");
    System.out.println("-----------------------------");

    System.out.println(obj1 == obj2);
    System.out.println(obj1 == obj3);
    System.out.println(obj2 == obj3);

    // protorype 객체
    // =>getBean() 호출할 때 마다 새 객체 만들어 리턴
    // => 가비지 발생
    // => 따라서, IoC 컨테이너는 기본적으로 single 방식으로 객체를 다움


  }

}


