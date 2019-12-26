package com.eomcs.oop.ex01.assignment;

import java.util.Scanner;

class Student {
  String name;
  int kor;
  int eng;
  int math;
  float avg;
  int sum;
}

public class Test01 {
  public static void main(String[] args) {

    final int SIZE = 100;
    Scanner sc = new Scanner(System.in);
    Student[] st = new Student[3];
    int count = 0;

    for (int i = 0 ; i < SIZE ; i++) {
      System.out.print("입력: ");
      Student s = new Student();

      s.name = sc.next();
      if (s.name.equalsIgnoreCase("quit")) {
        break;
      }
      count++;
      s.kor = sc.nextInt();
      s.eng = sc.nextInt();
      s.math = sc.nextInt();

      s.sum = s.kor + s.math + s.eng;
      s.avg = (float)s.sum / (float)3;
      st[i] = s;
    }

    System.out.println("--------------------------");
    sc.close();

    for (int i = 0 ; i < count ; i++) {
      Student s = st[i];
      System.out.printf("%s %d %d %d %d %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.avg);
    }

  }
}
