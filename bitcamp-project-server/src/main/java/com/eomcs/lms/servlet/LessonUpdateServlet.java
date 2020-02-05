package com.eomcs.lms.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.LessonFileDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateServlet implements Servlet {

  LessonFileDao lessonDao;

  public LessonUpdateServlet(LessonFileDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Lesson lesson = (Lesson) in.readObject();

    int index = -1;
    for (int i = 0; i < lessons.size(); i++) {
      if (lessons.get(i).getNo() == lesson.getNo()) {
        index = i;
        break;
      }
    }

    if (index != -1) {
      lessons.set(index, lesson);
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 수업이 없습니다.");
    }
  }
}
