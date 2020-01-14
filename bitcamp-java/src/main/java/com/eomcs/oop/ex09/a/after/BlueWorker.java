// 구현체(implementor) - 인터페이스에 따라 만든 클래스 
package com.eomcs.oop.ex09.a.after;

// 문법
// => class 클래스명 implements 인터페이스명, 인터페이스명, ... {...}
public class BlueWorker implements Worker {
    
    // 인터페이스(약속,규칙,규격,법률)를 이행하는 클래스는
    // 인터페이스에 선언된 모든 메서드를 반드시 구현해야 일반 메서드(concrete class)가 된다
    // 구현하지 않으면, 추상 메서드인 채로 존재하여 추상 메서드를 가진 클래스가 된다.
    // 추상 메서드는 추상 클래스 만이 가질 수 있다.
    // public abstract calss...
    public void execute() {
        System.out.println("육체 노동자가 일을 합니다!");
    }
    
}
