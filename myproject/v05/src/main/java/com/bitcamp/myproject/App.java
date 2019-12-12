package com.bitcamp.myproject;

import java.sql.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    System.out.print("품번 : ");
    int gameNum = sc.nextInt();
    sc.nextLine();
    System.out.print("게임명 : ");
    String gameName = sc.nextLine();
    System.out.print("제작사 : ");
    String gameProduction = sc.nextLine();
    System.out.print("발매일 : ");
    Date gameDate = Date.valueOf(sc.next());
    sc.nextLine();
    System.out.print("플랫폼 : ");
    String gamePlatform = sc.nextLine();
    System.out.print("장르 : ");
    String gameGenre = sc.nextLine();
    System.out.print("작화 : ");
    String gameIllust = sc.nextLine();
    System.out.print("음성 : ");
    String gameVoice = sc.nextLine();
    sc.close();
    System.out.println(); 
    System.out.printf("품번 : %d\n", gameNum);
    System.out.printf("게임명 : %s\n", gameName);
    System.out.printf("제작사 : %s\n", gameProduction);
    System.out.printf("발매일 : %s\n", gameDate);
    System.out.printf("플랫폼 : %s\n", gamePlatform);
    System.out.printf("장르 : %s\n", gameGenre);
    System.out.printf("작화 : %s\n", gameIllust);
    System.out.printf("음성 : %s\n", gameVoice);
    
  }
}
