package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Prompt;

public class App {

  static Scanner sc = new Scanner(System.in);
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>(); // 인터페이스 - 클래스

  public static void main(String[] args) {

    Prompt prompt = new Prompt(sc);
    LinkedList<Board> boardList = new LinkedList<>();
    BoardHandler boardHandler = new BoardHandler(prompt, boardList);
    LinkedList<Member> memberList = new LinkedList<>();
    MemberHandler memberHandler = new MemberHandler(prompt, memberList);
    ArrayList<Lesson> lessonList = new ArrayList<>();

    LessonHandler lessonHandler = new LessonHandler(prompt, lessonList);

    String command;
    while (true) {
      System.out.print("명령> ");
      command = sc.nextLine();

      if(command.length() == 0) 
        continue;

      commandStack.push(command);
      commandQueue.offer(command);

      switch(command) {
        case "/lesson/add" :
          lessonHandler.addLesson();
          break;
        case "/lesson/list" :
          lessonHandler.listLesson();
          break;
        case "/lesson/detail" :
          lessonHandler.detailLesson();
          break;
        case "/lesson/update" :
          lessonHandler.updateLesson();
          break;
        case "/lesson/delete" :
          lessonHandler.deleteLesson();
          break;
        case "/member/add" :
          memberHandler.addMember();
          break;
        case "/member/list" :
          memberHandler.listMember();
          break;
        case "/member/detail" :
          memberHandler.detailMember();
          break;
        case "/member/update" :
          memberHandler.updateMember();
          break;
        case "/member/delete" :
          memberHandler.deleteMember();
          break;
        case "/board/add" :
          boardHandler.addBoard();
          break;
        case "/board/list" :
          boardHandler.ListBoard();
          break;
        case "/board/detail" :
          boardHandler.detailBoard();
          break;
        case "/board/update" :
          boardHandler.updateBoard();
          break;
        case "/board/delete" :
          boardHandler.deleteBoard();
          break;
        case "history" :
          printCommandHistory(commandStack.iterator());
          break;
        case "history2" :
          printCommandHistory(commandQueue.iterator());
          break;
        case "quit" :
          System.out.println("안녕!");
          sc.close();
          System.exit(0);
        default :
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
      if(++count % 5 == 0 ) {
        System.out.print(" : ");
        String str = sc.nextLine();
        if (str.equalsIgnoreCase("q")) 
          break;
      }
    }
  }
}