package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Member;

public class MemberList {
  
  private static final int DEFAULT_CAPACITY = 100;
  private int size = 0; 
  private Member[] list;
  
  public MemberList() {
    list = new Member[DEFAULT_CAPACITY];
  }

  public void add(Member m) {
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
    this.list[this.size++] = m;
  }

  public Member[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }
  
  

}
