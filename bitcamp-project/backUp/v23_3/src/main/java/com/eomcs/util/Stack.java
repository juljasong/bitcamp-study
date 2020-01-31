package com.eomcs.util;

import java.util.Arrays;

// empty() / push() / pop()
public class Stack<E> implements Cloneable { // Cloneable 인터페이스 지정

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
  /*
  // shallow copy
  @Override
  public Stack clone() {
    try {
      return (Stack)super.clone();
    } catch (CloneNotSupportedException e) {
      // Object의 clone() 메서드는 복제 허용된 객체에 대해서만 변수를 복제한다
      // 복제가 허용되지 않은 객체에 대해 clone()을 호출하면 
      // CloneNotSupportedException
      // => clone()을 재정의하는 메서드 Cloneable 인터페이스 지정 (해당 객체가 복제할 수 있음을 표시)
      System.out.println(e);
      return null;
    }
  }
   */

  @SuppressWarnings("unchecked")
  // deep copy : 데이터의 배열을 그대로 복제 -> 배열 값 바꾸더라도 우너본 객체에 영향을 끼치지 않음
  @Override
  public Stack<E> clone() {
    try {
      // 1) shallow copy로 이 객체의 인스턴스 변수 그대로 복제
      Stack<E> temp = (Stack<E>)super.clone();
      // 2) elementData 배열 복제 -> 배열만 복제하고 그 배열에 저장된 객체는 복제 X
      Object[] arr = new Object[this.size];
      for(int i = 0 ; i < this.size ; i++) {
        arr[i] = this.elementData[i];
      }
      // 3) 복제한 스택 객체가 새로 만든 배열 가리키도록 함
      temp.elementData = arr;
      return (Stack<E>)temp;
      
    } catch (CloneNotSupportedException e) {
      System.out.println(e);
      return null;
    }
  }
}
