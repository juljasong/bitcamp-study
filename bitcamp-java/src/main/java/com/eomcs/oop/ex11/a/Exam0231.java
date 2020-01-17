// non-static nested class = inner class
package com.eomcs.oop.ex11.a;

public class Exam0231 {
  class Exam0231_X {
    class A {
      String name;
      int age;

      public A(final String name, final int age) {
        this.name = name;
        this.age = age;
      }

      void m1() {}
    }

    int iValue;

    void im() {}
  }


  public static void main(final String[] args) {


    new Exam0231_X();


  }
}
