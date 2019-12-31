package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;

public class MemberList {
  
  private static final int DEFAULT_CAPACITY = 100;
  private int size = 0; 
  private Member[] list;
  
  public MemberList() {
    list = new Member[DEFAULT_CAPACITY];
  }

  public void add(Member m) {
    this.list[this.size++] = m;
  }

  public Member[] toArray() {
    Member[] arr = new Member[this.size];
    for(int i = 0 ; i < this.size ; i++) {
      arr[i] = this.list[i]; 
    }
    return arr;
  }
  
  

}
