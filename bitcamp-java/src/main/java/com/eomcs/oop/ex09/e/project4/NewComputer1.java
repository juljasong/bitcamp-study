package com.eomcs.oop.ex09.e.project4;

import com.eomcs.oop.ex09.e.Computer2;

public class NewComputer1 implements Computer2{

  public void compute() {
    System.out.println("새 컴퓨터..");
  }

  public void touch() {
    System.out.println("오호라.. 터치가 되네. 이거 서피스 프로인가?");
  }
}
