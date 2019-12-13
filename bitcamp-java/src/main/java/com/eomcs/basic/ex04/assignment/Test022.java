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

public class Test022 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.print("가위, 바위, 보? ");
    String user = sc.next();
    sc.close();
    int com = ((int) (Math.random() * 10)) % 3; // 0 : 가위 , 1 : 바위 , 2 : 보

    if (!user.equals("가위") && !user.equals("바위") && !user.equals("보")) {
      System.out.println("뭘 내신거죠?");
    } else {
      switch (com) {
        case 0:
          System.out.println("컴퓨터 : 가위");
          if (user.equals("가위")) {
            System.out.println("비겼습니다.");
          } else if (user.equals("바위")) {
            System.out.println("이겼습니다.");
          } else {
            System.out.println("졌습니다.");
          }
          break;
        case 1:
          System.out.println("컴퓨터 : 바위");
          if (user.equals("보")) {
            System.out.println("이겼습니다.");
          } else if (user.equals("바위")) {
            System.out.println("비겼습니다.");
          } else {
            System.out.println("졌습니다.");
          }
          break;
        case 2:
          System.out.println("컴퓨터 : 보");
          if (user.equals("바위")) {
            System.out.println("졌습니다.");
          } else if (user.equals("가위")) {
            System.out.println("이겼습니다.");
          } else {
            System.out.println("비겼습니다.");
          }
          break;
        default:
          System.out.println("Error");
      }
    }
  }
}
