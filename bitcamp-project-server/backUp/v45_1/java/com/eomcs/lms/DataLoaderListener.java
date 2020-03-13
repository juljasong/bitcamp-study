package com.eomcs.lms;

import java.io.InputStream;
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
import com.eomcs.lms.service.impl.BoardServiceImpl;
import com.eomcs.lms.service.impl.LessonServiceImpl;
import com.eomcs.lms.service.impl.MemberServiceImpl;
import com.eomcs.lms.service.impl.PhotoBoardServiceImpl;
import com.eomcs.sql.MybatisDaoFactory;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.sql.SqlSessionFactoryProxy;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {
      // Mybatis 객체 준비
      InputStream inputStream =
          Resources.getResourceAsStream("com/eomcs/lms/conf/mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryProxy((new SqlSessionFactoryBuilder().build(inputStream)));

      // DAO 프록시 객체 생성해줄 Factory 준비
      MybatisDaoFactory daoFactory = new MybatisDaoFactory(sqlSessionFactory);

      LessonDao lessonDao = (LessonDao) daoFactory.createDao(LessonDao.class);
      BoardDao boardDao = (BoardDao) daoFactory.createDao(BoardDao.class);
      MemberDao memberDao = (MemberDao) daoFactory.createDao(MemberDao.class);
      PhotoBoardDao photoBoardDao = (PhotoBoardDao) daoFactory.createDao(PhotoBoardDao.class);
      PhotoFileDao photoFileDao = (PhotoFileDao) daoFactory.createDao(PhotoFileDao.class);
      // 이 메서드를 호출한 쪽(App)에서 DAO 객체를 사용할 수 있도록 Map 객체에 담아둔다.

      // 트랜잭션 관리자 준비
      PlatformTransactionManager txManager = new PlatformTransactionManager(sqlSessionFactory);
      context.put("transactionManager", txManager);
      context.put("sqlSessionFactory", sqlSessionFactory);

      context.put("lessonService", new LessonServiceImpl(lessonDao));
      context.put("photoBoardService",
          new PhotoBoardServiceImpl(txManager, photoBoardDao, photoFileDao));
      context.put("boardService", new BoardServiceImpl(boardDao));
      context.put("memberService", new MemberServiceImpl(memberDao));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {

  }

}
