// 제네릭(Generic) - 사용 전 : 다형적 변수 활용의 문제점
package com.eomcs.generic.ex01;

public class Exam0112 {
  
  // 다양한 객체를 저장하는 Box 만들기 위해 인스턴스 변수 타입을 Object로 선언
  static class ObjectBox {
    Object value;
    
    public void set(Object value) {
      this.value = value;
    }
    
    public Object get() {
      return value;
    }
  }

  public static void main(String[] args) {

    ObjectBox box1 = new ObjectBox();
    box1.set(new Member("홍길동", 16));
    // 값 꺼내기
    Member m = (Member)box1.get(); // 값을 꺼낼 때 원래의 타입으로 바꾸기 위해 형변환(type casting) 필요
    System.out.println(m);
    
    /* String */
    ObjectBox box2 = new ObjectBox();
    box2.set(new String("Hello"));
    String str = (String)box2.get();
    System.out.println(str);
    
    /* Integer */
    ObjectBox box3 = new ObjectBox();
    box3.set(100);
    int i = (int)box3.get(); 
    System.out.println(i);

  }
}








