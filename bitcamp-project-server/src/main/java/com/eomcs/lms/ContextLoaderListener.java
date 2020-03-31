package com.eomcs.lms;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 서블릿 컨테이너가 시작하거나 종료할 때 이 클래스의 객체에 대해 메서드 호출
// 즉 이 클래스는 서블릿 컨테이너의 시작과 종료에 대해 알림을 받는다.
// 단, javax.servlet.ServletContextListener 인터페이스 구현해야 한다.

@WebListener // 서블릿 컨테이너 관리
public class ContextLoaderListener implements ServletContextListener {

  static Logger logger = LogManager.getLogger(ContextLoaderListener.class);

  @Override
  public void contextInitialized(ServletContextEvent sce) {

    ServletContext serveletContext = sce.getServletContext();

    try {

      ApplicationContext iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
      serveletContext.setAttribute("iocContainer", iocContainer);
      ContextLoaderListener.logger.debug("----------------------------");

      // 서블릿 관리 서블릿 컨테이너가 함

      // 현재 Spring IoC 컨테이너에 들어있는 객체 확인
      printbeans(iocContainer);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void printbeans(ApplicationContext appCtx) {
    System.out.println("---- Spring IoC 컨테이너에 들어있는 객체들 ----");
    String[] beanNames = appCtx.getBeanDefinitionNames();
    for (String beanName : beanNames) {
      System.out.printf("%s =======> %s\n", beanName,
          appCtx.getBean(beanName).getClass().getName());
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    // 서블릿 컨테이너 종료되기 직전 호출
    // 주로 서블릿이 사용한 자원 해제
  }

}
