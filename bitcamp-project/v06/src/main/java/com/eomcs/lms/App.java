package com.eomcs.lms;

//import java.util.Date;
import java.util.Scanner;
import java.sql.Date;

public class App {
  
  static final int size = 5000;
  static int[] num = new int[size];
  static String[] title = new String[size];
  static String[] description = new String[size];
  static Date[] startDate = new Date[size];
  static Date[] endDate = new Date[size];
  static int[] totalHours = new int[size];
  static int[] dayHours = new int[size];
  static int count = 0;
  
    public static void main(String[] args) {
      
      inputClass();

      printClass();

    }

    private static void inputClass() {
      Scanner sc = new Scanner(System.in);
      for (int i = 0 ; i < size ; i++) {
      System.out.print("번호? ");
      num[i] = sc.nextInt();
      sc.nextLine();
      System.out.print("수업명? ");
      title[i] = sc.nextLine();
      System.out.print("설명? ");
      description[i] = sc.nextLine();
      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(sc.next());
      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(sc.next());
      System.out.print("총수업시간? ");
      totalHours[i] = sc.nextInt();
      System.out.print("일수업시간? ");
      dayHours[i] = sc.nextInt();
      System.out.println();
      count++;
      System.out.print("계속 입력하시겠습니까?(Y/N) ");
      String res = sc.next();
      if(res.equalsIgnoreCase("Y")) {
        System.out.println();
        continue;
      } else
        sc.close();
        break;
      }
    }
    
    private static void printClass() {
      System.out.println();
      for (int i = 0 ; i < count ; i++) {
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          num[i], title[i], startDate[i], endDate[i], totalHours[i]);
      }

    }
}