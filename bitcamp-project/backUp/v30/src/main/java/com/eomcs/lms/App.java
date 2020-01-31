package com.eomcs.lms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.util.Prompt;

public class App {

  static Scanner sc = new Scanner(System.in);
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>(); // 인터페이스 - 클래스
  static List<Lesson> lessonList = new ArrayList<>();
  static List<Board> boardList = new ArrayList<>();
  static List<Member> memberList = new ArrayList<>();

  public static void main(String[] args) {

    // 파일에서 데이터 로딩
    loadLessonData();
    loadMemberData();
    loadBoardData();

    Prompt prompt = new Prompt(App.sc);
    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/board/add", new BoardAddCommand(prompt, App.boardList));
    commandMap.put("/board/list", new BoardListCommand(App.boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(prompt, App.boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(prompt, App.boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(prompt, App.boardList));

    commandMap.put("/member/add", new MemberAddCommand(prompt, App.memberList));
    commandMap.put("/member/list", new MemberListCommand(App.memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(prompt, App.memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(prompt, App.memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(prompt, App.memberList));

    commandMap.put("/lesson/add", new LessonAddCommand(prompt, App.lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(App.lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(prompt, App.lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(prompt, App.lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(prompt, App.lessonList));

    String command;
    while (true) {
      System.out.print("명령> ");
      command = App.sc.nextLine();

      if (command.length() == 0)
        continue;

      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equals("history")) {
        printCommandHistory(App.commandStack.iterator());
        System.out.println();
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(App.commandQueue.iterator());
        System.out.println();
        continue;
      }
      App.commandStack.push(command);
      App.commandQueue.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
          System.out.println();
        }
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }
    App.sc.close();
    saveLessonData();
    saveMemberData();
    saveBoardData();
  }

  private static void printCommandHistory(Iterator<String> iter) {
    Iterator<String> iterator = iter;
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      if (++count % 5 == 0) {
        System.out.print(" : ");
        String str = App.sc.nextLine();
        if (str.equalsIgnoreCase("q"))
          break;
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static void loadLessonData() {

    File file = new File("./lesson.ser2");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      App.lessonList = (List<Lesson>) in.readObject();
      System.out.printf("%d개의 수업 데이터, ", App.lessonList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private static void loadMemberData() {
    File file = new File("./member.ser2");
    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      App.memberList = (List<Member>) in.readObject();
      System.out.printf("%d개의 멤버 데이터, ", App.memberList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private static void loadBoardData() {
    File file = new File("./board.ser2");

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      App.boardList = (List<Board>) in.readObject();
      System.out.printf("%d개의 게시글 데이터를 로딩했습니다.\n", App.boardList.size());
      System.out.println();
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveLessonData() {
    File file = new File("./lesson.ser2");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(App.lessonList);
      System.out.printf("%d개의 수업 데이터, ", App.lessonList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveMemberData() {
    File file = new File("./member.ser2");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(App.memberList);
      System.out.printf("%d개의 멤버 데이터, ", App.memberList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveBoardData() {
    File file = new File("./board.ser2");
    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeObject(App.boardList);
      System.out.printf("%d개의 게시글 데이터를 저장했습니다.\n", App.boardList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }
}
