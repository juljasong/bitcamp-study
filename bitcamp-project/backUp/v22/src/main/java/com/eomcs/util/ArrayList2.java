package com.eomcs.util;

import java.util.Arrays;

public class ArrayList2<E> {

  private static final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  private int size;

  public ArrayList2() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList2(int initialCapacity) {
    if (initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }

  public void add(E e) {
    int oldCapacity = this.elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (this.elementData.length == this.size) {
      this.elementData = Arrays.copyOf(this.elementData, newCapacity);
    }
    this.elementData[this.size++] = e;
  }

  @SuppressWarnings("unchecked")
  public E get(int idx) {
    if(idx < 0 || idx >= this.size) {
      return null;
    }
    return (E)this.elementData[idx];
  }

  @SuppressWarnings("unchecked")
  public E set(int idx, E e) {
    Object old = this.elementData[idx];
    if(idx < 0 || idx >= this.size) {
      return null;
    }
    this.elementData[idx] = e;
    return (E)old;
  }

  @SuppressWarnings("unchecked")
  public E remove(int idx) {
    Object old = this.elementData[idx];
    if(idx < 0 || idx >= this.size) {
      return null;
    }
    /*
    for (int i = idx ; i < this.size ; i++) {
      this.elementData[i] = this.elementData[i + 1];
    }
     */
    System.arraycopy(this.elementData, idx + 1, this.elementData, idx, this.size - 1);
    this.size--;
    return (E)old;
  }

  public int size() {
    return this.size;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray() {
    return (E[])Arrays.copyOf(this.elementData, this.size);
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if(arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    } 
    System.arraycopy(this.elementData, 0, arr, 0, this.size); // 그대로
    return arr;

  }

}
