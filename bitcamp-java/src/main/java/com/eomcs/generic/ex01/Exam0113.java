// 제네릭(Generic) - 사용 후 : 다형적 변수 한계 극복
package com.eomcs.generic.ex01;

public class Exam0113 {
  
  static class Box<T> { // T : Box 클래스가 다루는 객체의 타입 => 타입 파라미터
                        /* T - type
                         * E - element
                         * K - key
                         * N - number
                         * V - value
                         * 
                         * ! 여러 개의 타입 파라미터를 선언해야 할 경우 !
                         * S, U, V 등
                         *  ex) class Box<T, S, U, V> { ... }
                         */
    T value;
    
    public void set(T value) {
      this.value = value;
    }
    
    public T get() {
      return value;
    }
  }

  public static void main(String[] args) {

    Box<Member> box1 = new Box<>();
    box1.set(new Member("홍길동", 16));
    // 값 꺼내기
    Member m = box1.get();
    System.out.println(m);
    
    /* String */
    Box<String> box2 = new Box<>();
    box2.set(new String("Hello"));
    String str = box2.get();
    System.out.println(str);
    
    /* Integer */
    Box<Integer> box3 = new Box<>();
    box3.set(100);
    int i = box3.get(); 
    System.out.println(i);

  }
}








