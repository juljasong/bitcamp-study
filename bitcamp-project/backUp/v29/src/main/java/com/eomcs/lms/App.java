package com.eomcs.lms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
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

  private static void loadLessonData() {

    File file = new File("./lesson.data");
    try (DataInputStream in =
        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        Lesson lesson = new Lesson();
        lesson.setNum(in.readInt());
        lesson.setTitle(in.readUTF());
        lesson.setDescription(in.readUTF());
        lesson.setStartDate(Date.valueOf(in.readUTF()));
        lesson.setEndDate(Date.valueOf(in.readUTF()));
        lesson.setTotalHours(in.readInt());
        lesson.setDayHours(in.readInt());
        App.lessonList.add(lesson);
      }
      System.out.printf("%d개의 수업 데이터, ", App.lessonList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void loadMemberData() {
    File file = new File("./member.data");
    try (DataInputStream in =
        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        Member member = new Member();
        member.setNo(in.readInt());
        member.setName(in.readUTF());
        member.setEmail(in.readUTF());
        member.setPassword(in.readUTF());
        member.setPhoto(in.readUTF());
        member.setTel(in.readUTF());
        member.setRegisteredDate(Date.valueOf(in.readUTF()));
        App.memberList.add(member);
      }
      System.out.printf("%d개의 멤버 데이터, ", App.memberList.size());
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void loadBoardData() {
    File file = new File("./board.data");

    try (DataInputStream in =
        new DataInputStream(new BufferedInputStream(new FileInputStream(file)))) {
      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        Board board = new Board();
        board.setNo(in.readInt());
        board.setTitle(in.readUTF());
        board.setDate(Date.valueOf(in.readUTF()));
        board.setViewCount(in.readInt());
        App.boardList.add(board);
      }
      System.out.printf("%d개의 게시글 데이터를 로딩했습니다.\n", App.boardList.size());
      System.out.println();
    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveLessonData() {
    File file = new File("./lesson.data");
    try (DataOutputStream out =
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(App.lessonList.size());
      for (Lesson lesson : App.lessonList) {
        out.writeInt(lesson.getNum());
        out.writeUTF(lesson.getTitle());
        out.writeUTF(lesson.getDescription());
        out.writeUTF(lesson.getStartDate().toString());
        out.writeUTF(lesson.getEndDate().toString());
        out.writeInt(lesson.getTotalHours());
        out.writeInt(lesson.getDayHours());
      }
      System.out.printf("%d개의 수업 데이터, ", App.lessonList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveMemberData() {
    File file = new File("./member.data");
    try (DataOutputStream out =
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(App.memberList.size());
      for (Member member : App.memberList) {
        out.writeInt(member.getNo());
        out.writeUTF(member.getName());
        out.writeUTF(member.getEmail());
        out.writeUTF(member.getPassword());
        out.writeUTF(member.getPhoto());
        out.writeUTF(member.getTel());
        out.writeUTF(member.getRegisteredDate().toString());

      }
      System.out.printf("%d개의 멤버 데이터, ", App.memberList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }

  private static void saveBoardData() {
    File file = new File("./board.data");
    try (DataOutputStream out =
        new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.writeInt(App.boardList.size());
      for (Board board : App.boardList) {
        out.writeInt(board.getNo());
        out.writeUTF(board.getTitle());
        out.writeUTF(board.getDate().toString());
        out.writeInt(board.getViewCount());
      }
      System.out.printf("%d개의 게시글 데이터를 저장했습니다.\n", App.boardList.size());
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
    }
  }
}
