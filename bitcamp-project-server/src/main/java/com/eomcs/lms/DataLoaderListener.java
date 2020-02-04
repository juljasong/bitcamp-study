package com.eomcs.lms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class DataLoaderListener implements ApplicationContextListener {

  List<Lesson> lessonList = new ArrayList<>();
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new ArrayList<>();

  @Override
  public void contextInitialized(Map<String, Object> context) {
    loadLessonData();
    loadMemberData();
    loadBoardData();
    System.out.println("데이터를 로딩했습니다.");

    // 데이터가 저장되어 있는 List 객체를 이 메서드를 호출한 쪽에서 사용할 수 있도록
    // Map 객체에 담아둔다.
    context.put("boardList", boardList);
    context.put("memberList", memberList);
    context.put("lessonList", lessonList);
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    saveLessonData();
    saveMemberData();
    saveBoardData();
    System.out.println("데이터를 저장했습니다.");
  }

  @SuppressWarnings("unchecked")
  private void loadLessonData() {

    File file = new File("./lesson.ser2");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      lessonList = (List<Lesson>) in.readObject();
      System.out.printf("%d개의 수업 데이터, ", lessonList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void loadMemberData() {
    File file = new File("./member.ser2");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      memberList = (List<Member>) in.readObject();
      System.out.printf("%d개의 멤버 데이터, ", memberList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void loadBoardData() {
    File file = new File("./board.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      boardList = (List<Board>) in.readObject();
      System.out.printf("%d개의 게시글 ", boardList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private void saveLessonData() {
    File file = new File("./lesson.ser2");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(lessonList);
      System.out.printf("%d개의 수업 데이터, ", lessonList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }

  private void saveMemberData() {
    File file = new File("./member.ser2");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(memberList);
      System.out.printf("%d개의 멤버 데이터, ", memberList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }

  private void saveBoardData() {
    File file = new File("./board.ser2");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(boardList);
      System.out.printf("%d개의 게시글 ", boardList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }

}
