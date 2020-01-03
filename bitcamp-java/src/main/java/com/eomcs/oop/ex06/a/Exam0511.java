// 다형성 - 다형적 변수의 형변환 응용 - instanceof 연산자
package com.eomcs.oop.ex06.a;

public class Exam0511 {
  public static void main(String[] args) {

    Vehicle v = new Sedan();

    // instanceof : 레퍼런스에 들어있는 주소가 특정 클래스의 인스턴스인지 검사
    // => 수퍼 클래스인 경우도 검사

    /* true */
    System.out.println(v instanceof Sedan);
    System.out.println(v instanceof Car);
    System.out.println(v instanceof Vehicle);
    System.out.println(v instanceof Object);
    
    /* false */
    System.out.println(v instanceof Truck);
    System.out.println(v instanceof Bike);

  }
}




