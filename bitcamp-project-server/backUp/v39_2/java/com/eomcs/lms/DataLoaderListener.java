package com.eomcs.lms;

import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.util.ConnectionFactory;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {
      // DB 연결 객체 준비
      String jdbcUrl = "jdbc:mariadb://localhost:3306/studydb";
      String userName = "study";
      String password = "1111";

      ConnectionFactory conFactory = new ConnectionFactory(jdbcUrl, userName, password);

      // 이 메서드를 호출한 쪽(App)에서 DAO 객체를 사용할 수 있도록 Map 객체에 담아둔다.
      context.put("boardDao", conFactory);
      context.put("lessonDao", conFactory);
      context.put("memberDao", conFactory);
      context.put("photoBoardDao", conFactory);
      context.put("photoFileDao", conFactory);

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다.");
  }
}
