// Worker 구현체 사용
package com.eomcs.oop.ex09.a.before;

public class Exam01 {
    public static void main(String[] args) {
        BlueWorker w1 = new BlueWorker();
        WhiteWorker w2 = new WhiteWorker();
        JubuWorker w3 = new JubuWorker();

        w1.doFight();
        w2.doZingZing();
        w3.doSsingSsing();
        // 객체에 일을 시키는 방식은 엇비슷하지만, 메서드 시그너처가 다르기 때문에 호출 시 일관성 X
        // 일관된 방법으로 메서드를 호출할 수 있도록 인터페이스(사용 규칙) 정의
        
    }
}



