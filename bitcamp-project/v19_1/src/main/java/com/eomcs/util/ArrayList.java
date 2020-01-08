package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {

  private static final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  private int size;

  /* 생성자  */
  public ArrayList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if(initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }

  public void add(E e) {
    if(this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + (oldSize >> 1);
      this.elementData = Arrays.copyOf(this.elementData, newSize);
      /*
      Object[] newArr = new Object[newSize];
      for(int i = 0 ; i < this.size ; i++) {
        newArr[i] = this.elementData[i];
      }
      this.elementData = newArr;
       */
    }
    this.elementData[this.size++] = e;
  }
  /*
  public void add(int idx, E e) {
    if (idx < 0 || idx >= this.size) {
      return;
    }
    System.arraycopy(elementData, idx , elementData, idx + 1, this.size + 1);
    this.size++;
    this.elementData[idx] = e;
  }
  */

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      //System.out.println("유효한 인덱스가 아닙니다.");
      return null;
    }
    return (E)this.elementData[index];
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    E old = (E)this.elementData[index];
    if (index < 0 || index >= this.size) {
      return null;
    }
    this.elementData[index] = e;
    return old;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    E old = (E)this.elementData[index];
    if (index < 0 || index >= this.size) {
      return null;
    }
    /*
    for(int i = index + 1 ; i < this.size ; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
     */
    System.arraycopy(this.elementData, index + 1, this.elementData, index, this.size - (index + 1));
    this.size--;
    return old;
  }

  public int size() {
    return this.size;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray() {
    return (E[])Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for(int i = 0 ; i < this.size ; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
     */
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if(arr.length < this.size) {
      // 파라미터로 받은 배열이 작을 때, 새 배열을 만들어 리턴
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }
    // 넉넉할 때 파라미터로 받은 배열 그대로 리턴
    System.arraycopy(this.elementData, 0, arr, 0, size);
    return arr;
  }
}