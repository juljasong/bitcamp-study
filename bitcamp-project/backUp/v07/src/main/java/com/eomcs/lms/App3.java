package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

// 입력을 카운트하기
public class App3 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    /*
    class Board {
      int no, viewCount;
      String title;
      Date date;
    }
    */

    final int SIZE = 100;
    Board[] boards = new Board[SIZE];
    String response;
    int count = 0;

    for (int i = 0 ; i < SIZE ; i++) {
      boards[i] = new Board();
    }


    for (int i = 0; i < SIZE; i++) {
      Board b = boards[i];
      System.out.print("번호? ");
      b.no = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호 제거용

      System.out.print("내용? ");
      b.title = keyboard.nextLine();

      b.date = new Date(System.currentTimeMillis());
      b.viewCount = 0;

      count++;

      System.out.println();

      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }


    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
      Board board = boards[i];
      System.out.printf("%d, %s, %s, %d\n", 
          board.no, board.title, board.date, board.viewCount);
    }
  }
}








