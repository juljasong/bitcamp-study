package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao {

  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드를 정의한다.
  int insert(Lesson lesson) throws Exception;

  List<Lesson> findAll() throws Exception;

  Lesson findByNo(int no) throws Exception;

  int update(Lesson lesson) throws Exception;

  int delete(int no) throws Exception;

}


