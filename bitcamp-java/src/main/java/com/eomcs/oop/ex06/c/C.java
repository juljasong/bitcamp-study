package com.eomcs.oop.ex06.c;

public class C {
    private void m1() {} // 현재 클래스만 접근
    void m3() {} // 현재 클래스 + 같은 패키지 소속 클래스
    protected void m2() {} // 현재 클래스 + 같은 패키지 클래스 + 자식 클래스 접근 가능
    public void m4() {}
}
