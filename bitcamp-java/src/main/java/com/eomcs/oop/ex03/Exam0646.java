// 초기화 블록 - 클래스 블록 = 스태틱 블록
package com.eomcs.oop.ex03;

public class Exam0646 {

  public static class A {
    static int a;
    static void m() {}

    // 스태틱 블록은 클래스가 로딩된 후에 자동으로 순서대로 실행된다.
    static {
      System.out.println("Static{} 11111");
    }

    static {
      System.out.println("Static{} 22222");
    }
    {
    	System.out.println("실행?");
    }
  }

  public static void main(String[] args) throws Exception {

    // 클래스가 로딩되는 경우
    
    // 0) 클래스 필드 생성
    // 1) 클래스 멤버(변수와 메서드)를 최초로 사용할 때.
    //   A.a = 100;
    //   A.m();
    // 2)  해당 클래스의 인스턴스를 최초로 생성할 때
    //   new A();
    // 3) 자바에서 제공하는 도구를 사용하여 클래스를 로딩할 때 
    //   Class.forname("step08.Exam06_4$5");
    
    // 클래스가 로딩된 후
    // 1) 클래스 필드 생성
    // 2) 클래스 블록(스태틱 블록) 실행
    // => 레퍼런스를 선언할 때는 클래스가 로딩되지 않는다.

    // 클래스 중복 로딩 X
    A.a = 100;
    A.m();
    new A();
    System.out.println("--------");

    //이전에 이미 클래스가 로딩되었기 때문에 다시 로딩되지 않는다
    // -> static 블록은 다시 실행X
    new A();

  }
}





