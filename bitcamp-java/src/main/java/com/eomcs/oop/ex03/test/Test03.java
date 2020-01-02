package com.eomcs.oop.ex03.test;

public class Test03 {
  public static void main(String[] args) {

    Car c1 = new Car();
    Car c2 = new Car();
    
    /* static 메소드 => 클래스명으로 접근 */
    Car.start(c1);
    System.out.println("c1.on = " + c1.on);
    System.out.println("c2.on = " + c2.on);
    
    /* non-static 메소드 => 인스턴스 명으로 접근 */
    c1.speedUp();
    System.out.println("c1.speed = " + c1.speed);
    
    c1.check();
    System.out.println("-----");
    c1.check();
  }

}
