// 과제 1 : 가위,바위,보 게임 애플리케이션을 작성하라.
// - 실행1
// 가위,바위,보? 보
// 컴퓨터: 가위 (랜덤 값이 출력된다. 힌트: Math.random())
// => 졌습니다.

// - 실행2
// 가위,바위,보? 바위
// 컴퓨터: 가위
// => 이겼습니다.

package com.eomcs.basic.ex04.assignment;

import java.util.Scanner;

public class Test023 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int user = 100;

    System.out.print("가위 바위 보? ");
    String s = sc.nextLine();

    if (s.equals("가위") || s.equals("바위") || s.equals("보")) {

      switch (s) {
        case "가위":
          user = 1;
          break;
        case "바위":
          user = 2;
          break;
        case "보":
          user = 3;
          break;
      }
      // 1 가위 2 바위 3 보
      int com = ((int) (Math.random() * 10) % 3) + 1;

      switch (com) {
        case 1:
          System.out.println("컴퓨터 : 가위");
          break;
        case 2:
          System.out.println("컴퓨터 : 바위");
          break;
        case 3:
          System.out.println("컴퓨터 : 보");
          break;
        default:

      }
      if (user - com == -1 || user - com == 2)
        System.out.println("졌습니다.");
      else if (user - com == -2 || user - com == 1)
        System.out.println("이겼습니다.");
      else if (user - com == 0)
        System.out.println("비겼습니다.");
      else {

      }
    } else 
      System.out.println("잘못된 값입니다. 프로그램을 종료합니다.");
    sc.close();
  }
}
