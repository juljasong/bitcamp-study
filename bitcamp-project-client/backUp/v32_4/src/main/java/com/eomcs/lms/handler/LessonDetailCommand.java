package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonDetailCommand implements Command {
  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public LessonDetailCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int index = prompt.inputInt("강의 번호? ");
      out.writeUTF("/lesson/detail");
      out.writeInt(index);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      Lesson lesson = (Lesson) in.readObject();
      System.out.println("수업명: " + lesson.getTitle());
      System.out.println("수업내용: " + lesson.getDescription());
      System.out.printf("기간 : %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
      System.out.println("총수업시간: " + lesson.getTotalHours());
      System.out.println("일수업시간: " + lesson.getDayHours());
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생");
    }
  }

}
