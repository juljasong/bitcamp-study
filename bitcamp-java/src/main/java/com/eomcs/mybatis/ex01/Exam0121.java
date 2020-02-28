// Mybatis - 컬럼 이름과 프로퍼티 일치시키기
package com.eomcs.mybatis.ex01;

import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0121 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream =
        Resources.getResourceAsStream("com/eomcs/mybatis/ex01/mybatis-config.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = factory.openSession();
    List<Board> list = sqlSession.selectList("BoardMapper.selectBoard2");

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", board.getNo(), board.getTitle(), board.getContent(),
          board.getRegisteredDate(), board.getViewcount());
    }

    sqlSession.close();
  }

  /*
   * <select id="selectBoard2" resultType="com.eomcs.mybatis.ex01.Board"> select board_id (AS) no,
   * title, contents AS content, created_date AS registeredDate, view_count AS viewcount from
   * x_board </select>
   */

}


