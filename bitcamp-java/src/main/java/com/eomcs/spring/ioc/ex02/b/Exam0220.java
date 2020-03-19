// 객체 생성 - bean의 별명 알아내기
package com.eomcs.spring.ioc.ex02.b;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.eomcs.spring.ioc.SpringUtils;

public class Exam0220 {

  public static void main(String[] args) {
    ApplicationContext iocContainer =
        new ClassPathXmlApplicationContext("com/eomcs/spring/ioc/ex02/b/application-context.xml");

    // 빈의 id와 별명 출력
    SpringUtils.printBeanList(iocContainer);

    // id만 지정한 경우
    String[] aliases = iocContainer.getAliases("c5");
    for (String alias : aliases) {
      System.out.println(alias);
    }
  }

}


