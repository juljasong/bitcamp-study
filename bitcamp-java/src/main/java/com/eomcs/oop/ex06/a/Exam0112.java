// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0112 {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        Bike b = new Bike();
        Car c = new Car();
        Sedan s = new Sedan();
        Truck t = new Truck();
        
        Bike b2 = null;
        // 하위 클래스 레퍼런스로 상위 클래스 인스턴스 가리킬 수 없음
        //b2 = v; // 컴파일 오류!
        
    }

}
