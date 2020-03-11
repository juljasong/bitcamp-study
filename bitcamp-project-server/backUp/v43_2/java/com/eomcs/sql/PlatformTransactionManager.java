package com.eomcs.sql;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PlatformTransactionManager {

  SqlSessionFactory sqlSessionFactory;

  public PlatformTransactionManager(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public void beginTransaction() throws Exception {
    // 기존 스레드에 존재하는 SqlSession 객체 지우기
    ((SqlSessionFactoryProxy) sqlSessionFactory).closeSession();

    // 수동커밋
    sqlSessionFactory.openSession(false);
  }

  public void commit() throws Exception {
    // 스레드에 보관된 sqlSession 객체 꺼내기
    SqlSession sqlSession = sqlSessionFactory.openSession();
    sqlSession.commit();
  }

  public void rollback() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    sqlSession.rollback();
  }

}
