package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.Prompt;

public class LessonAddCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public LessonAddCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {

    Lesson l = new Lesson();
    l.setNo(prompt.inputInt("번호? "));
    l.setTitle(prompt.inputString("수업명? "));
    l.setDescription(prompt.inputString("설명? "));
    l.setStartDate(prompt.inputDate("시작일? "));
    l.setEndDate(prompt.inputDate("종료일? "));
    l.setTotalHours(prompt.inputInt("총수업시간? "));
    l.setDayHours(prompt.inputInt("일수업시간? "));
    System.out.println();

    try {
      out.writeUTF("/lesson/add");
      out.writeObject(l);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      System.out.println("저장하였습니다.");
    } catch (Exception e) {
      System.out.println("통신 오류 발생");
    }
  }
}
