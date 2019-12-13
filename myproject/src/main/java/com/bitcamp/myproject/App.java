package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    int size = 5000;
    int[] gameNum = new int[size];
    String[] gameName = new String[size];
    String[] gameProduction = new String[size];
    Date[] gameDate = new Date[size];
    String[] gamePlatform = new String[size];
    String[] gameGenre = new String[size];
    String[] gameIllust = new String[size];
    String[] gameVoice = new String[size];
    int count = 0;

    Scanner sc = new Scanner(System.in);
    for(int i = 0 ; i < size ; i++) {
      System.out.print("품번 : ");
      gameNum[i] = sc.nextInt();
      sc.nextLine();
      System.out.print("게임명 : ");
      gameName[i] = sc.nextLine();
      System.out.print("제작사 : ");
      gameProduction[i] = sc.nextLine();
      System.out.print("발매일 : ");
      gameDate[i] = Date.valueOf(sc.next());
      sc.nextLine();
      System.out.print("플랫폼 : ");
      gamePlatform[i] = sc.nextLine();
      System.out.print("장르 : ");
      gameGenre[i] = sc.nextLine();
      System.out.print("작화 : ");
      gameIllust[i] = sc.nextLine();
      System.out.print("음성 : ");
      gameVoice[i] = sc.nextLine();
      count++;
      System.out.println();
      System.out.print("계속 입력하시겠습니까?(Y|N) ");
      String res = sc.nextLine();
      System.out.println();
      if (res.equalsIgnoreCase("Y")) {
        continue;
      }
      sc.close();
      break;
    }
    
    for (int j = 0 ; j < count ; j++)  {
    System.out.printf("[%d] %s | %s | %s | %s\n", 
        gameNum[j], gameName[j], gameProduction[j], gameDate[j], gameGenre[j]);
    /*
    System.out.printf("품번 : %d\n", gameNum[j]);
    System.out.printf("게임명 : %s\n", gameName[j]);
    System.out.printf("제작사 : %s\n", gameProduction[j]);
    System.out.printf("발매일 : %s\n", gameDate[j]);
    System.out.printf("플랫폼 : %s\n", gamePlatform[j]);
    System.out.printf("장르 : %s\n", gameGenre[j]);
    System.out.printf("작화 : %s\n", gameIllust[j]);
    System.out.printf("음성 : %s\n", gameVoice[j]);
    */
    }
  }
}
