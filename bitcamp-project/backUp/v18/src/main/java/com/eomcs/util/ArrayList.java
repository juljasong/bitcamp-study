package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {

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
  
  @SuppressWarnings({"unchecked"})
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
    }
    System.arraycopy(this.list, 0, arr, 0, this.size);
    /*
    for(int i = 0 ; i < arr.length ; i++) {
      arr[i] = (E) this.list[i];
    }
    */
    return arr;
  }

  public void add(E obj) {
    
    if (this.getSize() == this.list.length) { // 현재 배열에 게시글 객체가 차면, 배열을 늘림
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
      System.out.println();
    }
    this.list[this.size++] = obj;
  }
  @SuppressWarnings("unchecked")
  public E detail(int idx) {
    if (idx >= 0 && idx <this.getSize()) {
      return (E)this.list[idx];
    } else {
      return null;
    }
  }

  public int getSize() {
    return this.size;
  }
}