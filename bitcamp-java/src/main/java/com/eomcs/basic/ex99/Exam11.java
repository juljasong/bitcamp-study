package com.eomcs.basic.ex99;

public class Exam11 {
  public static void main(String[] args) {

    // 값 출력하기 
    // println()

    System.out.println(100);
    System.out.println(3.14);
    System.out.println(true);
    System.out.println('가');
    System.out.println("안녕하세요 감사해요 잘있어요");

    System.out.print(100);
    System.out.print(3.14);
    System.out.print(true);
    System.out.print('가');
    System.out.print("안녕하세요 감사해요 잘있어요");
    System.out.print("\n");
    System.out.print("OK\n");
    System.out.print("NO!");

    String name = "미오";

    System.out.printf("\n이름 : %s", name);
    System.out.printf("\n나이 : %d살", 20);
    System.out.printf("\n이름(나이) : %s(%d)", "미오", 16);

    System.out.printf("\n%d, %x, %c", 65, 65, 65); // 65, 41(16진법), A
    // $ 순서지정 
    System.out.printf("\n%1$d, %1$x, %1$c", 65);
    
    // 논리값
    System.out.printf("\n재직자 : %s %b", true, true);
    System.out.printf("\n나이 : %d살 %s", 20, 20);

    // 출력할 공간 확보
    System.out.printf("\n이름 : %s", "홍길동");
    System.out.printf("\n이름 : [%20s]", "홍길동"); // [                 홍길동]
    System.out.printf("\n이름 : [%-20s]", "홍길동"); // [홍길동                 ]
    System.out.printf("\n숫자 : [%d]", 12345); // [12345]
    System.out.printf("\n숫자 : [%10d]", 12345); // [     12345]
    System.out.printf("\n숫자 : [%-10d]", 12345); // [12345     ]
    System.out.printf("\n숫자 : [%010d]", 12345); // [0000012345]
    System.out.printf("\n숫자 : [%+010d] [%+010d]", 12345, -12345); // [+000012345] [-000012345]

    // 일시 다루기
    java.util.Date today = new java.util.Date();
    today.setDate(9);
    System.out.printf("\n%s", today);

    // 날짜 객체에서 년, 월, 일, 시, 분, 초, 요일 추출
    System.out.printf("\n%tY %ty", today, today); // 년 : 2019, 19
    System.out.printf("\n%tB %tb %tm", today, today, today); // 월 : 12월, 12월, 12(영:December/Dec)
    System.out.printf("\n%td %te", today, today); // 일 : 09 9
    System.out.printf("\n%ta %tA", today, today); // 요일 : 월요일 월 (Monday Mon)
    System.out.printf("\n%tH %tI", today, today); // 시간 : 12 12
    System.out.printf("\n%tM", today); // 분 : 19
    System.out.printf("\n%tS %tL, %tN", today, today, today); // 초 : 55 926(밀리초), 926000000(나노초)
    System.out.printf("\n%tp, %Tp", today, today); // 오후 오후 (pm PM)
    
    // 2019-12-12 12:37:45

    System.out.printf("\n%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", today);

    String str = String.format("\n%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", today); // 문자열로 만들어서 리턴
    System.out.println(str);

  }
}