// Data Persistence Framework 도입 - Mybatis
package com.eomcs.mybatis.ex01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0112 {

  public static void main(String[] args) throws Exception {
    // mybatis 설정 파일을 읽을 InputStream도구를 준비한다.
    // => Resources의 getResourceAsStream() 메서드는
    // 파라미터에 지정한 파일 경로를 CLASSPATH에서 찾는다.
    // 그리고 그 파일을 읽을 수 있는 InputStream 도구를 리턴한다.
    // => 개발자가 mybatis-config.xml 파일의 전체 경로를 지정하지 않아도 되기 때문에
    // 매우 편리하다.
    // => 단 해당 파일은 CLASSPATH에 있어야 한다.

    // SqlSession 공작 객체로부터 SqlSession 객체를 얻는다.
    SqlSessionFactory factory = new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsStream("com/eomcs/mybatis/ex01/mybatis-config.xml"));

    SqlSession sqlSession = factory.openSession();

    System.out.println("mybatis 준비 완료!");

    sqlSession.close();
  }

}


