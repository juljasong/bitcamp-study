package com.eomcs.oop.ex08.test;
/* Encapsulation */

public class I {
  private int a;
  private int b;
  
  public int getA() {
    return a;
  }
  public void setA(int a) {
    this.a = a;
  }
  public int getB() {
    return b;
  }
  public void setB(int b) {
    this.b = b;
  }
  // getter / setter => property
  
}

class TestI{
  public static void main(String[] args) {
    I obj = new I();
    //obj.a = 100;
    //obj.b = 100;
    obj.setA(100);
    obj.setB(100);
  }
}
