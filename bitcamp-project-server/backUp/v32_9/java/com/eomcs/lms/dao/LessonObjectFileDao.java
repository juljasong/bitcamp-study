package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.dao.json.AbstractJsonFileDao;
import com.eomcs.lms.domain.Lesson;

public class LessonObjectFileDao extends AbstractJsonFileDao<Lesson> {

  public LessonObjectFileDao(String filename) {
    super(filename);
  }

  // 서블릿 객체들이 데이터를 다룰 때 사용할 메서드를 정의한다.
  public int insert(Lesson lesson) throws Exception {
    if (indexOf(lesson.getNo()) > -1) {
      return 0;
    }
    list.add(lesson); // 새 게시물을 등록한다.
    saveData();
    return 1;
  }

  public List<Lesson> findAll() throws Exception {
    return list;
  }

  public Lesson findByNo(int no) throws Exception {

    int index = indexOf(no);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Lesson lesson) throws Exception {
    int index = indexOf(lesson.getNo());
    if (index == -1)
      return 0;

    list.set(index, lesson); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
    saveData();
    return 1;

  }

  public int delete(int no) throws Exception {
    int index = indexOf(no);
    if (index == -1) {
      return 0;
    }
    list.remove(index);
    saveData();
    return 1;
  }

  private int indexOf(int no) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == no) {
        return i; // 해당 숫자 리턴
      }
    }
    return -1; // 해당 숫자 없으면 -1
  }

  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getNo() == (int) key) {
        return i; // 해당 숫자 리턴
      }
    }
    return -1;
  }
}


