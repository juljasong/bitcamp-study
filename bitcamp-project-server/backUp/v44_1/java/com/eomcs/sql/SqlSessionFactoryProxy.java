package com.eomcs.sql;

import java.sql.Connection;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.TransactionIsolationLevel;

public class SqlSessionFactoryProxy implements SqlSessionFactory {

  SqlSessionFactory originalFactory;

  // SqlSession을 스레드에 보관할 저장소 준비

  ThreadLocal<SqlSession> sqlSessionLocal = new ThreadLocal<>();

  public SqlSessionFactoryProxy(SqlSessionFactory originalFactory) {
    this.originalFactory = originalFactory;
  }

  public void closeSession() { // 스레드 작업 종료 후 SqlSession 객체 제거 후 닫기
    SqlSession sqlSession = sqlSessionLocal.get();
    if (sqlSession != null) {
      sqlSessionLocal.remove(); // 스레드에서 제거
      ((SqlSessionProxy) sqlSession).realClose(); // SqlSession 닫기
    }
  }

  @Override
  public SqlSession openSession() {
    return this.openSession(true);
  }

  @Override
  public SqlSession openSession(boolean autoCommit) {
    SqlSession sqlSession = sqlSessionLocal.get();

    if (sqlSession == null) {
      sqlSession = new SqlSessionProxy(originalFactory.openSession(autoCommit)); // Proxy -> 자동
                                                                                 // close() 막음
      sqlSessionLocal.set(sqlSession);
    }
    return sqlSession;
  }

  @Override
  public SqlSession openSession(Connection connection) {
    return originalFactory.openSession(connection);
  }

  @Override
  public SqlSession openSession(TransactionIsolationLevel level) {
    return originalFactory.openSession(level);
  }

  @Override
  public SqlSession openSession(ExecutorType execType) {
    return originalFactory.openSession(execType);
  }

  @Override
  public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
    return originalFactory.openSession(execType, autoCommit);
  }

  @Override
  public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
    return originalFactory.openSession(execType, level);
  }

  @Override
  public SqlSession openSession(ExecutorType execType, Connection connection) {
    return originalFactory.openSession(execType, connection);
  }

  @Override
  public Configuration getConfiguration() {
    return originalFactory.getConfiguration();
  }
}
