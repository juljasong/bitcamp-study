package com.eomcs.basic.ex99;

public class Exam231 {
  public static void main(String[] args) {

    // nextInt() 다음에 nextLine()를 호출할 때 공백 문자 읽히는 문제 해결
    java.util.Scanner sc = new java.util.Scanner(System.in);

    System.out.print("입력> ");
    int i1 = sc.nextInt();
    int i2 = sc.nextInt();
    //sc.next(); // 한 개의 token(단어)을 읽는다. 공백을 만날 때 까지 읽음. 값을 읽은 후 앞, 뒤 공백은 제거.
    String s = sc.next();

    System.out.println("--------------------");
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(s);

    // nextInt() : 스페이스, 탭, new line 만나면, 그 앞까지 입력한 문자열을 int값으로 바꿔 리턴
    // 입력한 문자열이 숫자를 의미하는 문자열이 아니면 int 값으로 바뀔 수 없어 실행 오류 발생
  }
}