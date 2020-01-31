package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Prompt;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

public class App {

  static Scanner sc = new Scanner(System.in);
  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(sc);

    BoardHandler boardHandler = new BoardHandler(prompt);
    MemberHandler memberHandler = new MemberHandler(prompt);
    LessonHandler lessonHandler = new LessonHandler(prompt);

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
          printCommandHistory();
          break;
        case "history2" :
          printCommandHistory2();
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
  private static void printCommandHistory() {
    Stack<String> historyStack = (Stack<String>)commandStack.clone();
    int count = 0;
    historyStack.pop();
    while (!historyStack.empty()) {
      System.out.println(historyStack.pop());
      count++;

      if(count % 5 == 0 ) {
        System.out.print(" : ");
        String str = sc.nextLine();
        if (str.equalsIgnoreCase("q")) 
          break;
      }
    }
  }

  private static void printCommandHistory2() {
    Queue<String> historyQueue = commandQueue.clone();
    int count = 0;
    while(historyQueue.size() > 0) {
      System.out.println(historyQueue.poll());
      if((++count % 5 == 0)) {
        System.out.print(" : ");
        String str = sc.nextLine();
        if(str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }

  }
}