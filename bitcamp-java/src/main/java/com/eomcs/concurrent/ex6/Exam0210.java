// 멀티 스레드 재사용 - Pooling 기법 이용
package com.eomcs.concurrent.ex6;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam0210 {

  static class MyThread extends Thread {
    ThreadPool pool;
    int count;

    public MyThread(String name, ThreadPool pool) {
      super(name);
      this.pool = pool;
    }

    public void setCount(int count) {
      this.count = count;
      synchronized (this) {
        notify(); // 동기화 영역에서 호출해야 함
      }
    }

    @Override
    public void run() {
      synchronized (this) {
        // System.out.println("스레드 대기중...!");
        try {
          while (true) {
            // 스레드를 시작하자 마자 일단 작업 지시 기다리게 한다
            // wait() 는 반드시 동기화 블록(synchronized 선언된 메서드/블록) 안에서 호출해야 함
            wait();
            // System.out.println("카운트 시작!");
            for (int i = count; i > 0; i--) {
              System.out.printf("[%s] %d\n", getName(), i);
              Thread.sleep(2000);
            }
            pool.add(this);
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  interface ThreadPool {
    Thread get();

    void add(Thread obj);
  }

  static class MyThreadPool implements ThreadPool {
    ArrayList<MyThread> list = new ArrayList<>();

    public MyThreadPool() {
      MyThread t1 = new MyThread("1st thread > ", this);
      t1.start();
      list.add(t1);

      MyThread t2 = new MyThread("2nd thread >> ", this);
      t2.start();
      list.add(t2);

      MyThread t3 = new MyThread("3rd thread >>> ", this);
      t3.start();
      list.add(t3);
    }

    // 스레드 풀에서 한 개의 스레드를 꺼낸다
    @Override
    public MyThread get() {
      if (list.size() > 0) {
        return list.remove(0);
      }
      return null;
    }

    @Override
    public void add(Thread t) {
      list.add((MyThread) t);
    }

  }

  public static void main(String[] args) {
    MyThreadPool threadPool = new MyThreadPool();
    Scanner keyScan = new Scanner(System.in);

    while (true) {
      System.out.print("카운트? ");
      String str = keyScan.nextLine();

      if (str.equals("quit")) {
        break;
      }

      int count = Integer.parseInt(str);
      // 스레드 풀에서 스레드 한 개 꺼냄
      MyThread t = threadPool.get();
      if (t == null) {
        System.out.println("남는 스레드가 없습니다!");
        continue;
      }
      t.setCount(count);
    }

    System.out.println("main 스레드 종료!");

    keyScan.close();
  }
}
