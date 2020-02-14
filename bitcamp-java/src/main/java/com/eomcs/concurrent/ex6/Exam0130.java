// 스레드 재사용 - 3단계 ) sleep()/timeout()
package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0130 {
  public static void main(String[] args) {

    class MyThread extends Thread {
      boolean enable;
      int count;

      public void setCount(int count) {
        this.count = count;
        this.enable = true;
      }

      @Override
      public void run() {
        System.out.println("스레드 시작했음!");
        try {
          while (true) {
            System.out.println("스레드를 10초 동안 잠들게 한다");
            Thread.sleep(10000);
            // enable이 true일 때만 작업
            if (!enable) {
              continue;
            }
            System.out.println("카운트 시작!");
            for (int i = count; i > 0; i--) {
              System.out.println("==> " + i);
              Thread.sleep(1000);
            }
            // 스레드에게 맡겨진 작업이 끝나면 비활성 상태로 설정한 후
            // 10초 동안 잠든다.
            enable = false;
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
      t.setCount(count);
      // 이전 버전과 다르게 스레드가 작업 완료하면 10초 동안 잠든다
      // 10초 후 깨어났을 때 카운트 값이 설정되어 있지 않으면 다시 잠든다.
    }
    System.out.println("main 스레드 종료!");

    keyScan.close();
  }
}
