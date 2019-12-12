package com.eomcs.basic.ex99;

public class Exam23 {
  public static void main(String[] args) {

    // 정수와 문자열 한 줄 입력 받기
    java.util.Scanner sc = new java.util.Scanner(System.in);

    System.out.print("입력> ");
    int i1 = sc.nextInt(); // space, tab, newLine 기호를 만나면 그 앞까지 읽은 입력값을 int로 만들어 리턴. 
                           // 현재 커서의 위치는 공백(white space: space/tab/newLine). 값을 읽고 난 후 공백을 제거하지 않음.
                           // 100|(_)200|_aaaaaa -> 다음 메소드는 공백부터 읽게 됨. nextInt()는 앞에 공백이 있으면 무시, 다음 공백이 있을 떄 까지 읽음.
    int i2 = sc.nextInt();
    sc.nextLine();
    String s = sc.nextLine();
    System.out.println("--------------------");
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(s);

    // nextInt() 다음에 nextLine()을 실행할 떄 nextLine()은 nextInt()가 읽은 값 다음부터 읽기 때문에 기대하지 않은 값이 반환될 수 있음.
  }
}