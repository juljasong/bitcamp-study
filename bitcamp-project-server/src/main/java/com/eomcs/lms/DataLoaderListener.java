package com.eomcs.lms;

import java.io.InputStream;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoFileDaoImpl;
import com.eomcs.sql.DataSource;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {
      // Mybatis
      InputStream mybatisConfigInputStream =
          Resources.getResourceAsStream("com/eomcs/lms/conf/mybatis-config.xml");
      SqlSessionFactory sqlSessionfactory =
          new SqlSessionFactoryBuilder().build(mybatisConfigInputStream);
      // 이 메서드를 호출한 쪽(App)에서 DAO 객체를 사용할 수 있도록 Map 객체에 담아둔다.
      context.put("boardDao", new BoardDaoImpl(sqlSessionfactory));
      context.put("lessonDao", new LessonDaoImpl(sqlSessionfactory));
      context.put("memberDao", new MemberDaoImpl(sqlSessionfactory));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(sqlSessionfactory));
      context.put("photoFileDao", new PhotoFileDaoImpl(sqlSessionfactory));

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    // 어플리케이션 종료시, 모든 DB 커넥션을 명시적으로 끊어줌
    // -> DBMS는 timeout 될 때 까지 기다릴 필요 없이 클라이언트와 연결된 스레드 즉시 해제
    DataSource dataSource = (DataSource) context.get("dataSource");
    dataSource.clean();
    System.out.println("데이터를 저장합니다.");
  }
}
