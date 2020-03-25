// 객체 생성 - bean의 별명 알아내기: 별명이 여러 개인 경우
package com.eomcs.spring.ioc.ex02.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam0230 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex02/b/application-context.xml");

    // 빈의 id와 별명 출력
    SpringUtils.printBeanList(iocContainer);

    String[] aliases = iocContainer.getAliases("c91");
    System.out.println("[별명]");
    for (String alias : aliases) {
      System.out.println(alias);
    }
    //
  }

}

