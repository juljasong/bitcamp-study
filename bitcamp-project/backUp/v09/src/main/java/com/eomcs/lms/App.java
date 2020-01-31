package com.eomcs.lms;

import java.util.Scanner;
import java.sql.Date;

public class App {

  static Scanner sc = new Scanner(System.in);

  static final int SIZE = 5000;
  static int lesson_count = 0;
  static int member_count = 0;
  static int board_count = 0;
  static Lesson[] lessons = new Lesson[SIZE];
  static User[] users = new User[SIZE];
  static Board[] boards = new Board[SIZE];

  public static void main(String[] args) {

    String command;
    while (true) {
      System.out.print("명령> ");
      command = sc.nextLine();

      switch(command) {
        case "/lesson/add" :
          lessonAdd();
          break;
        case "/lesson/list" :
          lessonList();
          break;
        case "/member/add" :
          memberAdd();
          break;
        case "/member/list" :
          memberList();
          break;
        case "/board/add" :
          boardAdd();
          break;
        case "/board/list" :
          boardList();
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

  static void lessonAdd() {
    Lesson l = new Lesson();
    System.out.print("번호? ");
    l.num = sc.nextInt();
    sc.nextLine();
    System.out.print("수업명? ");
    l.title = sc.nextLine();
    System.out.print("설명? ");
    l.description = sc.nextLine();
    System.out.print("시작일? ");
    l.startDate = Date.valueOf(sc.next());
    System.out.print("종료일? ");
    l.endDate = Date.valueOf(sc.next());
    System.out.print("총수업시간? ");
    l.totalHours = sc.nextInt();
    System.out.print("일수업시간? ");
    l.dayHours = sc.nextInt();
    sc.nextLine();
    lessons[lesson_count++] = l;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  static void lessonList() {
    for (int i = 0 ; i < lesson_count ; ) {
      Lesson l = lessons[i++];
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          l.num, l.title, l.startDate, l.endDate, l.totalHours);
    }
    System.out.println();
  }

  static void memberAdd() {
    User u = new User();
    System.out.print("번호? ");
    u.no = sc.nextInt();
    sc.nextLine();
    System.out.print("이름? ");
    u.name = sc.nextLine();
    System.out.print("이메일? ");
    u.email = sc.nextLine();
    System.out.print("암호? ");
    u.password = sc.nextLine();
    System.out.print("사진? ");
    u.photo = sc.nextLine();
    System.out.print("전화? ");
    u.tel = sc.nextLine();
    System.out.print("가입일? ");
    u.registeredDate = new Date(System.currentTimeMillis());
    System.out.println(u.registeredDate);
    users[member_count++] = u;
    System.out.println("저장하였습니다.");
    System.out.println();
  }

  static void memberList() {
    for (int i = 0 ; i < member_count ; ) {
      User u = users[i++];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          u.no, u.name, u.email, u.tel, u.registeredDate);
    }
    System.out.println();
  }

  static void boardList() {
    for (int i = 0; i < board_count; i++) {
      Board board = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          board.no, board.title, board.date, board.viewCount);
    }
    System.out.println();
  }

  static void boardAdd() {
    Board b = new Board();
    System.out.print("번호? ");
    b.no = sc.nextInt();
    sc.nextLine(); 
    System.out.print("내용? ");
    b.title = sc.nextLine();
    b.date = new Date(System.currentTimeMillis());
    b.viewCount = 0;
    System.out.println("저장하였습니다.");
    System.out.println();
    boards[board_count++] = b;
  }
}