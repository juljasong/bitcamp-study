// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0113 {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        Bike b = new Bike();
        Car c = new Car();
        Sedan s = new Sedan();
        Truck t = new Truck();
        
        Bike b2 = null;
        // 같은 수퍼 클래스 가지고 있어도 안됨
        //b2 = v; // 컴파일 오류!
        //b2 = c; // 컴파일 오류!
        //b2 = s; // 컴파일 오류!
        //b2 = t; // 컴파일 오류
    }

}
