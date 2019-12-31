package com.eomcs.lms.domain;

public class LessonList {
  
  private static final int DEFAULT_CAPACITY = 5000;
  private int size = 0;
  private Lesson[] list;
  
  public LessonList() {
    list = new Lesson[DEFAULT_CAPACITY];
  }

  public void add(Lesson l) {
    this.list[size++] = l;
  }

  public Lesson[] toArray() {
    Lesson[] arr = new Lesson[this.size];
    for (int i = 0 ; i < this.size ; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }
  
  

}
