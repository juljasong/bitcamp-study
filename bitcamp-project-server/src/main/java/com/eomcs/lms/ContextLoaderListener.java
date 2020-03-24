package com.eomcs.lms;

import java.lang.reflect.Method;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.util.RequestHandler;
import com.eomcs.util.RequestMapping;
import com.eomcs.util.RequestMappingHandlerMapping;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.

public class ContextLoaderListener implements ApplicationContextListener {

  static Logger logger = LogManager.getLogger(ContextLoaderListener.class);

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {

      ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
      // printbeans(appCtx);
      context.put("iocContainer", appCtx);
      ContextLoaderListener.logger.debug("----------------------------");

      RequestMappingHandlerMapping handlerMapper = new RequestMappingHandlerMapping();
      String[] beanNames = appCtx.getBeanNamesForAnnotation(Component.class);
      for (String beanName : beanNames) {
        Object component = appCtx.getBean(beanName);
        // @RequestHandler
        Method method = getRequestHandler(component.getClass());
        if (method != null) {
          // System.out.printf("%s.%s()\n", beanName, requestHandler.getName());
          RequestHandler requestHandler = new RequestHandler(method, component);
          // 명령 처리할 메서드 찾을 수 있도록 명령이름으로 메서드 정보 저장
          handlerMapper.addHandler(requestHandler.getPath(), requestHandler);
        }
      }

      context.put("handlerMapper", handlerMapper);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  // private void printbeans(ApplicationContext appCtx) {
  // System.out.println("---- Spring IoC 컨테이너에 들어있는 객체들 ----");
  // String[] beanNames = appCtx.getBeanDefinitionNames();
  // for (String beanName : beanNames) {
  // System.out.printf("%s =======> %s\n", beanName,
  // appCtx.getBean(beanName).getClass().getName());
  // }
  // }


  private Method getRequestHandler(Class<?> type) {
    // 클라이언트 명령을 처리할 메서드는 public 이기 때문에 클래스에서 public 메서드만 조사
    Method[] methods = type.getMethods();
    for (Method m : methods) {
      // @RequestMapping 붙은 메서드 조사
      RequestMapping anno = m.getAnnotation(RequestMapping.class);
      if (anno != null) {
        return m;
      }
    }
    return null;
  }


  @Override
  public void contextDestroyed(Map<String, Object> context) {

  }

}
