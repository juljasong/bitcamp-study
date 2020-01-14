// Worker 구현체 사용
package com.eomcs.oop.ex09.a.after;

// 1) worker 객체의 사용 규칙 정의 => 인터페이스 정의
// 2) 클래스 정의 시, Worker 규칙에 따라 만듬 -> BlueWorker, WhiteWorker, JubuWorker 클래스 변경
// 3) worker 사용 측에서는 Worker 인터페이스에 정의된 대로 메서드 호출 -> Exam01 변경

public class Exam01 {
    public static void main(String[] args) {
      
        // 같은 사용 규칙에 따라 만든 클래스는 인터페이스를 레퍼런스에 그 객체 주소를 저장할 수 있다
        // 인터페이스 레퍼런스
        // => 인터페이스를 구현한 클래스의 객체 주소를 저장하는 변수
        Worker w1 = new BlueWorker();
        
        // 인터페이스를 구현하지 않은 클래스의 인스턴스 주소를 저장할 수 없다. 
        //Worker w2 = new String();// 컴파일 오류!
        
        // 사용하려는 객체가 같은 인터페이스(사용규칙)을 구현하였다면, 
        // 다음과 같이 동일한 사용규칙에 따라 메서드를 호출할 수 있어 편리하다.
        
        Worker w2 = new WhiteWorker();
        Worker w3 = new JubuWorker();
        
        // 인터페이스 구현체 호출
        w1.execute();
        w2.execute();
        w3.execute();
        
        // 역할?
        // caller : Exam01
        // callee : BlueWorker, WhiteWorker, JubuWorker
        // 규칙: Worker
        
        // 인터페이스 레퍼런스 
        // => 해당 인터페이스에 따라 작성된(사용규칙 준수한) 클래스의 인스턴스 주소를 저장
        //  Worker 사용규칙에 따라 작성된 클래스의 인스턴스 주소 저장하는 변수 w
        // Worker 인터페이스 구현한 클래스의 인스턴스 주소 저장하는 변수 w
        // Worker 구현체의 인스턴스 주소 저장하는 변수 w
        // Worker 구현 객체 저장하는 변수  w
        // Worker  객체 저장하는 변수 w
        // Worker 객체 가리키는 변수 w
        
    }
}



