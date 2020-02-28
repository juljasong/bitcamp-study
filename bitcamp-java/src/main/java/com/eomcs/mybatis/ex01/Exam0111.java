// Data Persistence Framework 도입 - Mybatis 설정 파일 InputStream 얻는 방법
package com.eomcs.mybatis.ex01;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0111 {

  public static void main(String[] args) throws Exception {
    // 1. mybatis 설정 파일을 읽을 InputStream도구를 준비한다.
    // 파일 경로 직접 지정할 시, 애플리케이션 배포 경로 바뀔 때 마다 소스 변경하고 다시 컴파일 해야 함.

    /*
     * InputStream mybatisConfigInputStream = new
     * FileInputStream("./bin/main/com/eomcs/mybatis/ex01/mybatis-config.xml");
     */

    // 이를 간편하게 하기 위해 Mybatis 도우미 객체 제공
    // Resources 클래스의 메서드 이용 -> 자바 클래스가 있는 패키지 폴더에서 mybatis 설정 파일 찾기

    InputStream mybatisConfigInputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex01/mybatis-config.xml");
    // 파일 경로이기 때문에 . 대신 / 사용

    // 2. SqlSessionFactory 만들어 줄 빌더 객체 준비
    SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

    // 3. mybatis 설정 파일을 가지고 Builder를 이용하여 SqlSession 공장 객체를 생성한다.
    SqlSessionFactory factory = factoryBuilder.build(mybatisConfigInputStream);

    // 4. SQL 실행시킬 객체 준비 : SqlSession 공장 객체로부터 SqlSession 객체를 얻는다.
    SqlSession sqlSession = factory.openSession(); // .openSession() : 수동 커밋으로 SQL 다루는 객체 리턴.
                                                   // 자동 커밋 -> openSesson(true)
    System.out.println("mybatis 준비 완료!");

    sqlSession.close();
  }

}


