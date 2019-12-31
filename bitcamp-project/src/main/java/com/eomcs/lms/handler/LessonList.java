package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  
  private static final int DEFAULT_CAPACITY = 100;
  private int size = 0;
  private Lesson[] list;
  
  public LessonList() {
    list = new Lesson[DEFAULT_CAPACITY];
  }

  public void add(Lesson l) {
    if (this.size == this.list.length) { // 현재 배열에 게시글 객체가 차면, 배열을 늘림
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      /*
      Board[] arr = new Board[newCapacity];
      for (int i = 0 ; i < this.list.length; i++) {
        arr[i] = this.list[i];
      }
      this.list = arr;
      */
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.printf("새 배열을 %d개 생성하였습니다.", newCapacity);
      System.out.println();
    }
    this.list[size++] = l;
  }

  public Lesson[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  
  

}
