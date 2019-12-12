package com.eomcs.basic.ex99;

public class Exam21 {
  public static void main(String[] args) {

    // 키보드 정보를 가져온다

    java.io.InputStream keyboard = System.in;
    //java.io.PrintStream console = System.out;

    // 키보드 객체에 정수, 부동소수점, 논리값, 문자열 끊어서 읽어주는 도우미 객체 붙임

    java.util.Scanner sc = new java.util.Scanner(keyboard);

    String s1 = sc.nextLine();
    System.out.println(s1);

  }
}