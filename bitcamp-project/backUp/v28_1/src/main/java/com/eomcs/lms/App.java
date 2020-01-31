package com.eomcs.lms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
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
import com.eomcs.lms.handler.ComputeCommand;
import com.eomcs.lms.handler.HelloCommand;
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
  static ArrayList<Lesson> lessonList = new ArrayList<>();
  static LinkedList<Board> boardList = new LinkedList<>();
  static LinkedList<Member> memberList = new LinkedList<>();

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

    commandMap.put("/hello", new HelloCommand(prompt));
    commandMap.put("/compute/plus", new ComputeCommand(prompt));

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
    // 데이터가 보관된 파일의 정보 준비
    File file = new File("./lesson.csv"); // comma seperated value
    // 파일 읽을 때 사용할 도구 준비
    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(file);
      // .csv 파일에 한 줄 단위로 문자열을 읽는 기능 필요
      // -> FileReader에서 제공하는 데이터 읽기 도구가 사용하기에 적합하지 않아, 그대로 사용 불가
      // => 이 객체에 다른 도구 연결하여 사용 : Scanner
      dataScan = new Scanner(in);

      int count = 0;
      while (true) {
        try {
          String line = dataScan.nextLine(); // 파일에서 읽은 한 줄
          String[] data = line.split(", "); // 한 줄을 ,로 나눔
          // 데이터 순서 : 번호, 강의명, 설명, 시작일, 종료일, 총강의시간, 일강의시간
          Lesson lesson = new Lesson();
          lesson.setNum(Integer.parseInt(data[0]));
          lesson.setTitle(data[1]);
          lesson.setDescription(data[2]);
          lesson.setStartDate(Date.valueOf(data[3]));
          lesson.setEndDate(Date.valueOf(data[4]));
          lesson.setTotalHours(Integer.parseInt(data[5]));
          lesson.setDayHours(Integer.parseInt(data[6]));
          // command가 사용하는 목록에 lesson 객체 저장
          App.lessonList.add(lesson);
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 수업 데이터를 로딩했습니다.\n", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
      // 파일 읽기 중 오류 발생하더라도 시스템을 멈추지 않고 계속 실행하게 함.
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
        // Scanner 닫다가 오류 발생하더라도 무시
      }
      try {
        in.close();
      } catch (Exception e) {
        // close() 실행 오류 발생한 경우, 무시 -> 처리 방도 부재
      }
    }
  }

  private static void loadMemberData() {
    // 데이터가 보관된 파일의 정보 준비
    File file = new File("./member.csv"); // comma seperated value
    // 파일 읽을 때 사용할 도구 준비
    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(file);
      // .csv 파일에 한 줄 단위로 문자열을 읽는 기능 필요
      // -> FileReader에서 제공하는 데이터 읽기 도구가 사용하기에 적합하지 않아, 그대로 사용 불가
      // => 이 객체에 다른 도구 연결하여 사용 : Scanner
      dataScan = new Scanner(in);

      int count = 0;
      while (true) {
        try {
          String line = dataScan.nextLine(); // 파일에서 읽은 한 줄
          String[] data = line.split(", "); // 한 줄을 ,로 나눔
          // 데이터 순서 : 번호, 강의명, 설명, 시작일, 종료일, 총강의시간, 일강의시간
          Member member = new Member();
          member.setNo(Integer.parseInt(data[0]));
          member.setName(data[1]);
          member.setEmail(data[2]);
          member.setPassword(data[3]);
          member.setPhoto(data[4]);
          member.setTel(data[5]);
          member.setRegisteredDate(Date.valueOf(data[6]));

          App.memberList.add(member);
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 멤버 데이터를 로딩했습니다.\n", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
      // 파일 읽기 중 오류 발생하더라도 시스템을 멈추지 않고 계속 실행하게 함.
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
        // Scanner 닫다가 오류 발생하더라도 무시
      }
      try {
        in.close();
      } catch (Exception e) {
        // close() 실행 오류 발생한 경우, 무시 -> 처리 방도 부재
      }
    }
  }

  private static void loadBoardData() {
    // 데이터가 보관된 파일의 정보 준비
    File file = new File("./board.csv"); // comma seperated value
    // 파일 읽을 때 사용할 도구 준비
    FileReader in = null;
    Scanner dataScan = null;

    try {
      in = new FileReader(file);
      // .csv 파일에 한 줄 단위로 문자열을 읽는 기능 필요
      // -> FileReader에서 제공하는 데이터 읽기 도구가 사용하기에 적합하지 않아, 그대로 사용 불가
      // => 이 객체에 다른 도구 연결하여 사용 : Scanner
      dataScan = new Scanner(in);

      int count = 0;
      while (true) {
        try {
          String line = dataScan.nextLine(); // 파일에서 읽은 한 줄
          String[] data = line.split(", "); // 한 줄을 ,로 나눔
          // 데이터 순서 : 번호, 강의명, 설명, 시작일, 종료일, 총강의시간, 일강의시간
          Board board = new Board();
          board.setNo(Integer.parseInt(data[0]));
          board.setTitle(data[1]);
          board.setDate(Date.valueOf(data[2]));
          board.setViewCount(Integer.parseInt(data[3]));
          // command가 사용하는 목록에 lesson 객체 저장
          App.boardList.add(board);
          count++;
        } catch (Exception e) {
          break;
        }
      }
      System.out.printf("총 %d개의 게시글 데이터를 로딩했습니다.\n", count);
    } catch (FileNotFoundException e) {
      System.out.println("파일 읽기 중 오류 발생" + e.getMessage());
      // 파일 읽기 중 오류 발생하더라도 시스템을 멈추지 않고 계속 실행하게 함.
    } finally {
      try {
        dataScan.close();
      } catch (Exception e) {
        // Scanner 닫다가 오류 발생하더라도 무시
      }
      try {
        in.close();
      } catch (Exception e) {
        // close() 실행 오류 발생한 경우, 무시 -> 처리 방도 부재
      }
    }
  }

  private static void saveLessonData() {
    // 데이터가 보관된 파일의 정보 준비
    File file = new File("./lesson.csv"); // comma seperated value
    // 파일 쓸 때 사용할 도구 준비
    FileWriter out = null;
    try {
      out = new FileWriter(file);
      int count = 0;
      // 수업 목록에서 수업 데이터 꺼내 csv 형식 문자열로 만든다
      for (Lesson lesson : App.lessonList) {
        String line = String.format("%d, %s, %s, %s, %s, %d, %d\n", lesson.getNum(),
            lesson.getTitle(), lesson.getDescription(), lesson.getStartDate(), lesson.getEndDate(),
            lesson.getTotalHours(), lesson.getDayHours());

        out.write(line);
        count++;
      }
      System.out.printf("총 %d개의 수업 데이터를 저장했습니다.\n", count);
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
      // 파일 읽기 중 오류 발생하더라도 시스템을 멈추지 않고 계속 실행하게 함.
    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // close() 실행 오류 발생한 경우, 무시 -> 처리 방도 부재
      }
    }
  }

  private static void saveMemberData() {
    // 데이터가 보관된 파일의 정보 준비
    File file = new File("./member.csv"); // comma seperated value
    // 파일 쓸 때 사용할 도구 준비
    FileWriter out = null;
    try {
      out = new FileWriter(file);
      int count = 0;
      // 수업 목록에서 수업 데이터 꺼내 csv 형식 문자열로 만든다
      for (Member member : App.memberList) {
        String line = String.format("%d, %s, %s, %s, %s, %s, %s\n", member.getNo(),
            member.getName(), member.getEmail(), member.getPassword(), member.getPhoto(),
            member.getTel(), member.getRegisteredDate());
        out.write(line);
        count++;
      }
      System.out.printf("총 %d개의 멤버 데이터를 저장했습니다.\n", count);
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
      // 파일 읽기 중 오류 발생하더라도 시스템을 멈추지 않고 계속 실행하게 함.
    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // close() 실행 오류 발생한 경우, 무시 -> 처리 방도 부재
      }
    }
  }

  private static void saveBoardData() {
    // 데이터가 보관된 파일의 정보 준비
    File file = new File("./board.csv"); // comma seperated value
    // 파일 쓸 때 사용할 도구 준비
    FileWriter out = null;
    try {
      out = new FileWriter(file);
      int count = 0;
      // 수업 목록에서 수업 데이터 꺼내 csv 형식 문자열로 만든다
      for (Board board : App.boardList) {
        String line = String.format("%d, %s, %s, %d\n", board.getNo(), board.getTitle(),
            board.getDate(), board.getViewCount());

        out.write(line);
        count++;
      }
      System.out.printf("총 %d개의 게시글 데이터를 저장했습니다.\n", count);
    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생" + e.getMessage());
      // 파일 읽기 중 오류 발생하더라도 시스템을 멈추지 않고 계속 실행하게 함.
    } finally {
      try {
        out.close();
      } catch (IOException e) {
        // close() 실행 오류 발생한 경우, 무시 -> 처리 방도 부재
      }
    }
  }
}
