// 메서드 레퍼런스 - 생성자 레퍼런스 구현 원리
package com.eomcs.oop.ex12;

import java.util.ArrayList;
import java.util.List;

public class Exam0720 {

  static interface ListFactory {
    List create();
  }

  public static void main(String[] args) {

    // ListFactory f1 = ArrayList::new;

    ListFactory f1 = new ListFactory() {
      @Override
      public List create() {
        return new ArrayList();
      }
    };

    List list = f1.create(); // new ArrayList()

    System.out.println(list instanceof ArrayList);
    System.out.println(list.getClass().getName());

  }
}


