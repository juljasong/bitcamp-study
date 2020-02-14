// 스레드 재사용 - 2단계 ) sleep()/timeout()
package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0120 {
  public static void main(String[] args) {

    class MyThread extends Thread {
      int count;

      public void setCount(int count) {
        this.count = count;
      }

      @Override
      public void run() {
        System.out.println("스레드 시작했음!");
        try {
          // 스레드를 재사용하려면 다음과 같이 run() 메서드가 종료되지 않게 해야 함
          while (true) {
            // 사용자가 카운트 값 입력할 시간을 주기 위해 10초 정도 여유
            Thread.sleep(10000);
            System.out.println("카운트 시작!");
            for (int i = count; i > 0; i--) {
              System.out.println("==> " + i);
              Thread.sleep(1000);
            }
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

    MyThread t = new MyThread();

    t.start();
    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("카운트? ");
      String str = keyScan.nextLine();
      if (str.equals("quit")) {
        break;
      }
      int count = Integer.parseInt(str);
      t.setCount(count); // 스레드 카운트 값 변경
      // sleep() 방식은 일정 시간이 지난 후 스레드가 작업하게 만드는 방식
      // 스레드가 잠든 사이에 작업할 내용 변경해야 함 -> 스레드가 깨어나서 변경 사항에 따라 작업을 수행할 것
      // 스레드에 지정된 시간이 종료될 때 까지 작업이 바로 실행 X
      // 작업 시키고 싶지 않아도 깨어나면 작업할 것
    }

    System.out.println("main 스레드 종료!");

    keyScan.close();
  }
}
