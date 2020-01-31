package com.eomcs.util;

// Generalization 1단계 : ArrayList-LinkedList 간 공통 분모 추출하여 수퍼 클래스 정의
public class List<E> {
  protected int size;
  
  public int size() {
    return size;
  }
  
  public void add(E e) {}
  
  public void add(int index, E e) {}
  
  public E get(int index) {
    return null;
  }
  
  public E set(int index, E e) {
    return null;
  }
  
  public E remove(int index) {
    return null;
  }
  
  public Object[] toArray() {
    return null;
  }
  
  public E[] toArray(E[] arr) {
    return null;
  }
  

}
