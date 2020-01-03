// 다형성 - 다형적 변수의 형변환 응용 - instanceof 연산자
package com.eomcs.oop.ex06.a;

public class Exam0512 {
  public static void main(String[] args) {

    Vehicle v = new Sedan();

    // .getClass() : 레퍼런스가 가리키는 인스턴스의 실제 클래스 정보 리턴
    // => == 사용하여 비교
    
    /* class com.eomcs.oop.ex06.a.Sedan */
    System.out.println(v.getClass());
    System.out.println(Sedan.class);
    
    /* true */
    System.out.println(v.getClass() == Sedan.class);
    
    /* false */
    System.out.println(v.getClass() == Car.class);
    System.out.println(v.getClass() == Vehicle.class);
    System.out.println(v.getClass() == Truck.class);
    System.out.println(v.getClass() == Bike.class);

  }
}




