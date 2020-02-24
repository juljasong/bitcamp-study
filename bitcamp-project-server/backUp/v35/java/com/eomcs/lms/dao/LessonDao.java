package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Lesson;

public interface LessonDao {

  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드를 정의한다.
  public int insert(Lesson lesson) throws Exception;

  public List<Lesson> findAll() throws Exception;

  public Lesson findByNo(int no) throws Exception;

  public int update(Lesson lesson) throws Exception;

  public int delete(int no) throws Exception;

}


