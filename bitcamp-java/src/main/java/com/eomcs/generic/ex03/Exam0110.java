package com.eomcs.generic.ex03;

import java.lang.reflect.Array;

public class Exam0110 {
  static class ArrayList<T> {
    T[] arr;
    int index = 0;

    @SuppressWarnings("unchecked")
    public ArrayList(Class<?> clazz) {
      // 제네릭 타입 파라미터로 레퍼런스는 선언할 수 있지만, 배열 인스턴스 생성 불가
      //this.arr = new T[10];
      this.arr = (T[])Array.newInstance(clazz, 10);
    }

    public void add(T v) {
      arr[index++] = v;
    }

    public T get(int index) {
      return arr[index];
    }

    public static void main(String[] args) {

      ArrayList<Member> obj = new ArrayList<>(Member.class);
      obj.add(new Member());
      obj.add(new Student());
      obj.add(new Teacher());
      obj.add(new Manager());
      obj.add(new Administrator());

      // 클래스 관계 :
      /*
       *           member
       *       /     |      \ 
       * Teacher  Student  Manager
       *                     |
       *                Administrator
       */

      System.out.println(obj.get(0));
      System.out.println(obj.get(1));
      System.out.println(obj.get(2));
      System.out.println(obj.get(3));
    }
  }
}

