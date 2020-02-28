// Mybatis - mybatis02
package com.eomcs.mybatis.ex02;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0120 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex02/mybatis-config02.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    List<Board> list = sqlSession.selectList("BoardMapper.selectBoard");

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d \n", board.getNo(), board.getTitle(),
          board.getContent(), board.getRegisteredDate(), board.getViewcount());
    }

    sqlSession.close();
  }

}


