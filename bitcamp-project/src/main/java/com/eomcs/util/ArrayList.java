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
  public E get(int idx) {
    if (idx >= 0 && idx <this.getSize()) {
      return (E)this.list[idx];
    } else {
      return null;
    }
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E obj) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    E old = (E) this.list[index];
    this.list[index] = obj;
    
    return old;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    E old = (E) this.list[index];
    for (int i = index + 1 ; i < this.size; i++) { // 입력받은 index의 다음 부터
      this.list[i - 1] = this.list[i]; // 하나씩 앞으로 당기기
    }
    this.size--; // 사이즈 하나 줄이기
    this.list[this.size] = null; 
    return old;
  }

  public int getSize() {
    return this.size;
  }
  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ddd");
    list.add("ccc");
    
    /*
    list.set(0, "0000");
    list.set(1, "1111");
    list.set(5, "ㅎㅎ");
    */
    
    list.remove(3);
    
    String[] arr = list.toArray(new String[] {});
    for (String s : arr) {
      System.out.println(s);
    }
  }
}