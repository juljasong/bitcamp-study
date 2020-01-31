package com.eomcs.util;

import java.util.Arrays;

// empty() / push() / pop()
public class Stack<E> implements Cloneable {

  private static final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size;

  public Stack() {
    this.elementData = new Object[DEFAULT_CAPACITY];
    this.size = 0;
  }

  public void push(E value) {
    if (this.size == elementData.length) {
      grow();
    }
    this.elementData[size++] = value;
  }

  @SuppressWarnings("unchecked")
  public E pop() {
    if (this.empty()) 
      return null;
    E value = (E) this.elementData[--this.size];
    this.elementData[this.size] = null;
    return value;
  }

  private void grow() {
    this.elementData = Arrays.copyOf(this.elementData, newCapacity());
  }

  private int newCapacity() {
    int oldCapacity = elementData.length;
    return oldCapacity + (oldCapacity >> 1);
  }

  public boolean empty() {
    return this.size == 0;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Stack<E> clone() {
    try {
      Stack<E> temp = (Stack<E>)super.clone();
      Object[] arr = new Object[this.size];
      for(int i = 0 ; i < this.size ; i++) {
        arr[i] = this.elementData[i];
      }
      temp.elementData = arr;
      return (Stack<E>)temp;

    } catch (CloneNotSupportedException e) {
      System.out.println(e);
      return null;
    }
  }
  public Iterator<E> iterator() {

    return new Iterator<E>() {
      Stack<E> stack = (Stack<E>) Stack.this.clone();
      
      @Override
      public boolean hasNext() { // 다음 값 존재?
        return !stack.empty(); // 비어 있지 않으면 true
      }

      @Override
      public E next() { // 다음 값 리턴
        return stack.pop();
      }

    };
  }

}
