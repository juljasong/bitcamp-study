package com.eomcs.lms;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.sql.MybatisDaoFactory;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.sql.SqlSessionFactoryProxy;
import com.eomcs.util.ApplicationContext;
import com.eomcs.util.Component;
import com.eomcs.util.RequestHandler;
import com.eomcs.util.RequestMapping;
import com.eomcs.util.RequestMappingHandlerMapping;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class ContextLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {

      HashMap<String, Object> beans = new HashMap<>();

      // Mybatis 객체 준비
      InputStream inputStream =
          Resources.getResourceAsStream("com/eomcs/lms/conf/mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryProxy((new SqlSessionFactoryBuilder().build(inputStream)));
      // DAO 프록시 객체 생성해줄 Factory 준비
      MybatisDaoFactory daoFactory = new MybatisDaoFactory(sqlSessionFactory);

      beans.put("lessonDao", daoFactory.createDao(LessonDao.class));
      beans.put("boardDao", daoFactory.createDao(BoardDao.class));
      beans.put("memberDao", daoFactory.createDao(MemberDao.class));
      beans.put("photoFileDao", daoFactory.createDao(PhotoBoardDao.class));
      beans.put("photoFileDao", daoFactory.createDao(PhotoFileDao.class));
      // 이 메서드를 호출한 쪽(App)에서 DAO 객체를 사용할 수 있도록 Map 객체에 담아둔다.

      // 트랜잭션 관리자 준비
      PlatformTransactionManager txManager = new PlatformTransactionManager(sqlSessionFactory);
      beans.put("transactionManager", txManager);
      beans.put("sqlSessionFactory", sqlSessionFactory);

      ApplicationContext appCtx = new ApplicationContext(//
          "com.eomcs.lms", // 새로 생성할 객체의 패키지
          beans // 기존에 따로 생성한 객체 목록
      );
      // appCtx.printBeans();
      // ServerApp이 사용할 수 있게 context 맵에 담아 둔다.
      context.put("iocContainer", appCtx);
      System.out.println("------------------------------------------");

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
