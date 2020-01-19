// local class - 인스턴스 멤버에 선언된 로컬 클래스
package com.eomcs.oop.ex11.a;

public class Exam0340 {

	int iValue;
	// 인스턴스 메서드의 로컬 클래스 사용법
	void im() {
		// 이 인스턴스 메서드는 Exam0340 객체 주소를 받는 내장 변수 this가 있다.
		class A {
			void m1() {
				Exam0340.this.iValue = 100; // OK!
				System.out.println(iValue);
				
				iValue = 200; // OK!
				System.out.println(iValue);
			}
		}
		final A obj = new A();
		// 컴파일러는 위 코드를 바깥 클래스의 인스턴스 주소를 받는
		// 생성자 호출 코드로 바꾼다.
		// => final A obj = new A(this);
		//
		obj.m1();
	}
	
	
	public static void main(final String[] args) {
		
		final Exam0340 obj = new Exam0340(); // 인스턴스 멤버는 반드시 인스턴스를 생성한 후에 사용할 수 있다.
		obj.im();
		// im()을 호출할 때 Exam0340 객체를 넘겨준다.
		// 그러면 im() 에서는 this라는 내장 변수에 보관할 것이다.
	}
}
