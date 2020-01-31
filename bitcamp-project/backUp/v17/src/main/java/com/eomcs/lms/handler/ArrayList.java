package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList {

  private static final int DEFAULT_CAPACITY = 100;
  private int size = 0; 
  private Object[] list;

  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.list, this.size);
  }

  public void add(Object obj) {
    
    if (this.size == this.list.length) { // 현재 배열에 게시글 객체가 차면, 배열을 늘림
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.println();
    }
    this.list[this.size++] = obj;
  }

  public Object detail(int idx) {
    if (idx >= 0 && idx <this.size) {
      return this.list[idx];
    } else {
      return null;
    }
  }
}