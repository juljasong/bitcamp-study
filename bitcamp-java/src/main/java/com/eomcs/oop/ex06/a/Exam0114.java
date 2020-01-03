// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0114 {

    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        Bike b = new Bike();
        Car c = new Car();
        Sedan s = new Sedan();
        Truck t = new Truck();
        
        // 자식 클래스의 인스턴스는 가리킬 수 있음
        Car c2 = null;
        //c2 = v; // 컴파일 오류!
        //c2 = b; // 컴파일 오류!
        c2 = s; // OK
        c2.model = "티코";
        c2.capacity = 5;
        c2.cc = 890;
        c2.valve = 16;
        
        c2 = t; // OK
        
        Sedan s2 = null;
        //s2 = a; // 컴파일 오류!
        //s2 = b; // 컴파일 오류!
        //s2 = c; // 컴파일 오류!
        //s2 = t; // 컴파일 오류!
    }

}
