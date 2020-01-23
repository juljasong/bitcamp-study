package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

  public static void main(String[] args) {

    Prompt prompt = new Prompt(App.sc);
    LinkedList<Board> boardList = new LinkedList<>();
    BoardAddCommand boardAddCommand = new BoardAddCommand(prompt, boardList);
    BoardListCommand boardListCommand = new BoardListCommand(boardList);
    BoardDetailCommand boardDetailCommand = new BoardDetailCommand(prompt, boardList);
    BoardUpdateCommand boardUpdateCommand = new BoardUpdateCommand(prompt, boardList);
    BoardDeleteCommand boardDeleteCommand = new BoardDeleteCommand(prompt, boardList);

    LinkedList<Member> memberList = new LinkedList<>();
    MemberAddCommand memberAddCommand = new MemberAddCommand(prompt, memberList);
    MemberDeleteCommand memberDeleteCommand = new MemberDeleteCommand(prompt, memberList);
    MemberDetailCommand memberDetailCommand = new MemberDetailCommand(prompt, memberList);
    MemberListCommand memberListCommand = new MemberListCommand(memberList);
    MemberUpdateCommand memberUpdateCommand = new MemberUpdateCommand(prompt, memberList);

    ArrayList<Lesson> lessonList = new ArrayList<>();
    LessonAddCommand lessonAddCommand = new LessonAddCommand(prompt, lessonList);
    LessonUpdateCommand lessonUpdateCommand = new LessonUpdateCommand(prompt, lessonList);
    LessonDeleteCommand lessonDeleteCommand = new LessonDeleteCommand(prompt, lessonList);
    LessonDetailCommand lessonDetailCommand = new LessonDetailCommand(prompt, lessonList);
    LessonListCommand lessonListCommand = new LessonListCommand(lessonList);

    String command;
    while (true) {
      System.out.print("명령> ");
      command = App.sc.nextLine();

      if (command.length() == 0)
        continue;

      App.commandStack.push(command);
      App.commandQueue.offer(command);

      switch (command) {
        case "/lesson/add":
          lessonAddCommand.execute();
          break;
        case "/lesson/list":
          lessonListCommand.execute();
          break;
        case "/lesson/detail":
          lessonDetailCommand.execute();
          break;
        case "/lesson/update":
          lessonUpdateCommand.execute();
          break;
        case "/lesson/delete":
          lessonDeleteCommand.execute();
          break;
        case "/member/add":
          memberAddCommand.execute();
          break;
        case "/member/list":
          memberListCommand.execute();
          break;
        case "/member/detail":
          memberDetailCommand.execute();
          break;
        case "/member/update":
          memberUpdateCommand.execute();
          break;
        case "/member/delete":
          memberDeleteCommand.execute();
          break;
        case "/board/add":
          boardAddCommand.execute();
          break;
        case "/board/list":
          boardListCommand.execute();
          break;
        case "/board/detail":
          boardDetailCommand.execute();
          break;
        case "/board/update":
          boardUpdateCommand.execute();
          break;
        case "/board/delete":
          boardDeleteCommand.execute();
          break;
        case "history":
          printCommandHistory(App.commandStack.iterator());
          break;
        case "history2":
          printCommandHistory(App.commandQueue.iterator());
          break;
        case "quit":
          System.out.println("안녕!");
          App.sc.close();
          System.exit(0);
        default:
          System.out.println("실행할 수 없는 명령입니다.");
          System.out.println();
          break;
      }
    }
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
}
