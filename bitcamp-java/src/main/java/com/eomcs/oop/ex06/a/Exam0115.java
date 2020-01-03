// 다형성 - 다형적 변수(polymorphic variables)
package com.eomcs.oop.ex06.a;

public class Exam0115 {

    public static void main(String[] args) {
        // 상위 클래스의 페러펀스로 하위 클래스 의 인스턴스 가리킬 때
        Car c = new Sedan();
        
        c.model = "티코";
        c.capacity = 5;
        c.cc = 890;
        c.valve = 16;
        
        //c.sunroof = true; // 컴파일 오류!
        //c.auto = true; // 컴파일 오류!
        // Car에는 없기 때문에
        
        // ((인스턴스타입)레퍼런스).멤버변수
        ((Sedan)c).sunroof = true;
        ((Sedan)c).auto = true; // 가능
        
        // 인스턴스의 원래 클래스 레퍼런스에 저장한 다음에 사용
        Sedan s = (Sedan)c;
        s.sunroof = true;
        s.auto = true;
    }

}
