package com.eomcs.lms;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.sql.MybatisDaoFactory;
import com.eomcs.sql.PlatformTransactionManager;
import com.eomcs.sql.SqlSessionFactoryProxy;

// Spring IoC 컨테이너가 탐색할 패키지 설정

@ComponentScan(value = "com.eomcs.lms") // 지정 패키지와 하위 패키지에서 @Component가 붙은 클래스 찾아 객체 생성.
public class AppConfig {
  public AppConfig() throws Exception {

  }

  // Spring IoC 컨테이너에 수동으로 등록할 객체는 메서드를 만들어 리턴
  // => 메서드 선언부에 @Bean 붙여야 함
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/lms/conf/mybatis-config.xml");// Mybatis 객체 준비
    return new SqlSessionFactoryProxy((new SqlSessionFactoryBuilder().build(inputStream)));
  }

  @Bean
  public MybatisDaoFactory daoFactory(SqlSessionFactory sqlSessionFactory) {
    return new MybatisDaoFactory(sqlSessionFactory);
  }

  @Bean
  public PlatformTransactionManager platformTransactionManager(
      SqlSessionFactory sqlSessionFactory) {
    return new PlatformTransactionManager(sqlSessionFactory);
  }

  @Bean
  public BoardDao boardDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(BoardDao.class);
  }

  @Bean
  public LessonDao lessonDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(LessonDao.class);
  }

  @Bean
  public MemberDao memberDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(MemberDao.class);
  }

  @Bean
  public PhotoBoardDao photoBoardDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(PhotoBoardDao.class);
  }

  @Bean
  public PhotoFileDao PhotoFileDao(MybatisDaoFactory daoFactory) {
    return daoFactory.createDao(PhotoFileDao.class);
  }

}
