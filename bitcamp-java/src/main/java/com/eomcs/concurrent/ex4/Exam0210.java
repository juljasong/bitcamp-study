// 스레드의 생명주기(lifecycle) - 우선 순위 조회
package com.eomcs.concurrent.ex4;

public class Exam0210 {
  public static void main(String[] args) throws Exception {
    class MyThread extends Thread {
      public MyThread(String name) {
        super(name);
      }

      @Override
      public void run() {
        for (int i = 0; i < 1000; i++)
          System.out.printf("%s %d\n", this.getName(), i);
      }
    }

    MyThread t1 = new MyThread("t1");

    // 스레드의 우선 순위 범위
    System.out.printf("우선 순위 범위: %d ~ %d\n", Thread.MIN_PRIORITY, Thread.MAX_PRIORITY);

    System.out.printf("우선 순위 기본값: %d\n", Thread.NORM_PRIORITY);

    // "main" 스레드의 우선 순위 조회
    System.out.printf("main 스레드 우선 순위: %d\n", Thread.currentThread().getPriority());

    // "t1" 스레드의 우선 순위 조회
    // => "main" 스레드를 실행하는 동안 만든 스레드는 "main"의 자식 스레드라 부른다.
    // => 자식 스레드는 부모 스레드의 우선 순위와 같은 값을 갖는다.
    // 그래서 "t1" 스레드는 "main"의 우선 순위 값과 같다.
    System.out.printf("%s 스레드 우선 순위: %d\n", t1.getName(), t1.getPriority());

    // 우선순위가 높으면 CPU 사용 배분을 좀 더 자주 받음
    // => 스레드는 JVM에서 관리하는 것이 아닌 OS에서 관리
    // -> OS의 스레드 이용하여 우선 순위에 따라 실행 스케줄 어떻게 관리할지는 OS에 따라 다름
    // => Windows OS는 우선 순위 크게 고려 X .. Unix/Linux계열 OS는 우선 순위에 영향을 비교적 많이 받는다.
    // => 우선 순위를 고려하는 방식으로 프로그래밍하지 말 것

  }

}


