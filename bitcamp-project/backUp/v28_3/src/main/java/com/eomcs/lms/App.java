package com.eomcs.lms;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.google.gson.Gson;

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

  private static void loadLessonData() {

    File file = new File("./lesson.json");
    try (FileReader in = new FileReader(file)) {
      App.lessonList
          .addAll(new ArrayList<>(Arrays.asList(new Gson().fromJson(in, Lesson[].class))));
      System.out.printf("%d개의 수업 데이터, ", App.lessonList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void loadMemberData() {
    File file = new File("./member.json");
    try (FileReader in = new FileReader(file)) {
      App.memberList.addAll(Arrays.asList(new Gson().fromJson(in, Member[].class)));
      System.out.printf("%d개의 멤버 데이터, ", App.memberList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void loadBoardData() {
    File file = new File("./board.json");
    FileReader in = null;

    try {
      in = new FileReader(file);
      App.boardList.addAll(Arrays.asList(new Gson().fromJson(in, Board[].class)));
      System.out.printf("%d개의 게시글 데이터를 로딩했습니다.\n", App.boardList.size());
      System.out.println();
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    } finally {
      try {
        in.close();
      } catch (Exception e) {
      }
    }
  }

  private static void saveLessonData() {
    File file = new File("./lesson.json");
    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(App.lessonList));
      System.out.printf("%d개의 수업 데이터, ", App.lessonList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveMemberData() {
    File file = new File("./member.json");
    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(App.memberList));
      System.out.printf("%d개의 멤버 데이터, ", App.memberList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveBoardData() {
    File file = new File("./board.json");
    try (FileWriter out = new FileWriter(file)) {
      out.write(new Gson().toJson(App.boardList)); // gson 객체의 toJson()호출하여 boardList를 jason문자열로 만듬
      System.out.printf("%d개의 게시글 데이터를 저장했습니다.\n", App.boardList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }
}
