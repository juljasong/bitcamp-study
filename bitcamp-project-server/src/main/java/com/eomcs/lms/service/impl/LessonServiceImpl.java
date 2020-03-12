package com.eomcs.lms.service.impl;

import java.util.List;
import java.util.Map;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

public class LessonServiceImpl implements LessonService {

  LessonDao lessonDao;

  public LessonServiceImpl(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  // 별도의 작업을 하지 않지만, Dao 메서드 호출하여 리턴 받은 값을 그대로 리턴
  // => Servlet에서 Service 객체를 사용하도록 구조를 변경하여,
  // "프로그래밍 일관성"을 위해 해당 구조에 맞춘 것.
  @Override
  public Lesson get(int no) throws Exception {
    return lessonDao.findByNo(no);
  }

  @Override
  public int insert(Lesson lesson) throws Exception {
    return lessonDao.insert(lesson);
  }

  @Override
  public int delete(int no) throws Exception {
    return lessonDao.delete(no);
  }

  @Override
  public List<Lesson> list() throws Exception {
    return lessonDao.findAll();
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    return lessonDao.update(lesson);
  }

  @Override
  public List<Lesson> search(Map<String, Object> params) throws Exception {
    return lessonDao.findByKeyword(params);
  }

}
