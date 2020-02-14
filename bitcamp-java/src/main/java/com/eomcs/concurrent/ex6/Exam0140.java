// 스레드 재사용 - 3단계 ) notify()/wait()
package com.eomcs.concurrent.ex6;

import java.util.Scanner;

public class Exam0140 {
  public static void main(String[] args) {

    class MyThread extends Thread {

      int count;

      public void setCount(int count) {
        this.count = count;
        synchronized (this) {
          notify(); // 동기화 영역에서 호출해야 함
        }
      }

      @Override
      public void run() {
        synchronized (this) {
          System.out.println("스레드 대기중...!");
          try {
            while (true) {
              // 스레드를 시작하자 마자 일단 작업 지시 기다리게 한다
              // wait() 는 반드시 동기화 블록(synchronized 선언된 메서드/블록) 안에서 호출해야 함
              wait();
              System.out.println("카운트 시작!");
              for (int i = count; i > 0; i--) {
                System.out.println("==> " + i);
                Thread.sleep(1000);
              }
              System.out.println("스레드 대기중...!");
              Thread.sleep(10000);
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
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
