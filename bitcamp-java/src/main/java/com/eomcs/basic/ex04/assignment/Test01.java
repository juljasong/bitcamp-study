// 과제 1 : 계산기 애플리케이션을 작성하라.
// - 실행
// 값1? 10
// 값2? 20
// 연산자(+,-,*,/)? +
// => 10 + 20 = 30 

package com.eomcs.basic.ex04.assignment;

import java.util.Scanner;

public class Test01 {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("값1? ");
    int a = sc.nextInt();
    System.out.print("값2? ");
    int b = sc.nextInt();
    sc.nextLine();
    System.out.print("연산자(+,-,*,/)? ");
    String oper = sc.next();
    sc.close();
    /*
    if(oper.equals("+")) 
      System.out.printf("=> a + b = %d\n", a + b);
    else if (oper.equals("-")) 
      System.out.printf("=> a - b = %d\n", a - b);
    else if (oper.equals("*")) 
      System.out.printf("=> a * b = %d\n", a * b);
    else if (oper.equals("/")) {
      System.out.printf("=> a / b = %d\n", a / b);
    else 
      System.out.println("잘못된 값 입력.");
      return;
    }
    */

    switch(oper){
      case "+" :
      System.out.printf("=> a + b = %d\n", a + b);
      break;
      case "-" : 
      System.out.printf("=> a - b = %d\n", a - b);
      break;
      case "*" :
      System.out.printf("=> a * b = %d\n", a * b);
      break;
      case "/" :
      System.out.printf("=> a / b = %d\n", a / b);
      break;
      default : 
      System.out.println("잘못된 값입니다.");
      break;
    }
  }
}
