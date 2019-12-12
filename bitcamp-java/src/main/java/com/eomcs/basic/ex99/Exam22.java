package com.eomcs.basic.ex99;

public class Exam22 {
  public static void main(String[] args) {

    // 키보드 정보를 가져온다

    java.io.InputStream keyboard = System.in;
    //java.io.PrintStream console = System.out;

    // 키보드 객체에 정수, 부동소수점, 논리값, 문자열 끊어서 읽어주는 도우미 객체 붙임

    java.util.Scanner sc = new java.util.Scanner(keyboard);

    System.out.print("입력> ");
    int s1 = sc.nextInt();
    int s2 = sc.nextInt();
    int s3 = sc.nextInt();
    System.out.println("--------------------");
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);

    // nextInt() : 스페이스, 탭, new line 만나면, 그 앞까지 입력한 문자열을 int값으로 바꿔 리턴
    // 입력한 문자열이 숫자를 의미하는 문자열이 아니면 int 값으로 바뀔 수 없어 실행 오류 발생
  }
}