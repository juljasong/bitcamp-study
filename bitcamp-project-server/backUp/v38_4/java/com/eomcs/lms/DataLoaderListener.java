package com.eomcs.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoFileDaoImpl;

// 애플리케이션이 시작되거나 종료될 때
// 데이터를 로딩하고 저장하는 일을 한다.
//
public class DataLoaderListener implements ApplicationContextListener {
  public static Connection con;

  @Override
  public void contextInitialized(Map<String, Object> context) {

    try {
      // DB 연결 객체 준비
      Class.forName("org.mariadb.jdbc.Driver");
      DataLoaderListener.con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      // 이 메서드를 호출한 쪽(App)에서 DAO 객체를 사용할 수 있도록 Map 객체에 담아둔다.
      context.put("boardDao", new BoardDaoImpl(DataLoaderListener.con));
      context.put("lessonDao", new LessonDaoImpl(DataLoaderListener.con));
      context.put("memberDao", new MemberDaoImpl(DataLoaderListener.con));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(DataLoaderListener.con));
      context.put("photoFileDao", new PhotoFileDaoImpl(DataLoaderListener.con));

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    try {
      DataLoaderListener.con.close();
    } catch (Exception e) {
      // db커넥션 close 예외 발생 무시
    }
    System.out.println("데이터를 저장합니다.");
  }
}
