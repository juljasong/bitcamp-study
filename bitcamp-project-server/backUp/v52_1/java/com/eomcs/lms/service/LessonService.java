package com.eomcs.lms.service;

import java.util.List;
import java.util.Map;
import com.eomcs.lms.domain.Lesson;

public interface LessonService {

  Lesson get(int no) throws Exception;

  int insert(Lesson lesson) throws Exception;

  int delete(int no) throws Exception;

  List<Lesson> list() throws Exception;

  int update(Lesson lesson) throws Exception;

  List<Lesson> search(Map<String, Object> params) throws Exception;
}
