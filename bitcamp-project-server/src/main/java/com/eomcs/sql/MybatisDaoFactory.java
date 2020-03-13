package com.eomcs.sql;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MybatisDaoFactory {

  InvocationHandler invocationHandler;

  public MybatisDaoFactory(SqlSessionFactory sqlSessionFactory) {
    invocationHandler = (proxy, method, args) -> {
      // 할 일: SqlSession 이용하여 SQL 실행
      // 준비물:
      // 1) 실행할 SQL의 namespace와 id
      // 2) select 목록/ select 한 개/insert/update/delete 여부

      // 동작 원리
      // 1) 인터페이스명+메서드명 -> 실행할 SQL 아이디 알아냄
      // 2) 리턴 타입에 따라 호출할 메서드 결정
      // 3) 파라미터 유무에 따라 메서드에 넘길 항목 결정

      // => SQL ID 알아내기
      Class<?> clazz = proxy.getClass(); // 프록시 객체 정보 알아냄
      /* class(예약어) -> clazz/cls */
      Class<?> daoInterface = clazz.getInterfaces()[0]; // 프록시 객체가 구현한 인터페이스 정보 알아냄
      String interfaceName = daoInterface.getName();
      String sqlId = String.format("%s.%s", interfaceName, method.getName());
      System.out.println(sqlId);

      try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

        Class<?> returnType = method.getReturnType();

        if (returnType == List.class) {
          return (args == null) ? sqlSession.selectList(sqlId)
              : sqlSession.selectList(sqlId, args[0]);
        } else if (returnType == int.class || returnType == Void.class) {
          return (args == null) ? sqlSession.update(sqlId) : sqlSession.update(sqlId, args[0]); // update=insert=delete
        } else {
          return (args == null) ? sqlSession.selectOne(sqlId)
              : sqlSession.selectOne(sqlId, args[0]);
        }
      }
    };
  }

  @SuppressWarnings("unchecked")
  public <T> T createDao(Class<T> daoInterface) {
    return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[] {daoInterface},
        invocationHandler);
  }

}
