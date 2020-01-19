// anonymous class - 호출할 수퍼 클래스의 생성자 지정
package com.eomcs.oop.ex11.a;

public class Exam0450 {

	// 클래스는 스태틱으로 선언해야만 한다
	static class A {
		String name;

		public A() {
			name = "이름없음";
		}

		public A(final String name) {
			this.name = name;
		}

		public void print() {
			System.out.println(name);
		}
	}

	public static void main(final String[] args) {
		// 익명 클래스를 정의할 때 호출할 수퍼 클래스의 생성자 지정 가능
		// new 수퍼클래스명(파라미터, ...) {...}
		A obj = new A() {
			@Override
			public void print() {
				System.out.printf("%s님 반갑습니다!", name);
			}
		};
		obj.print();

		A obj1 = new A("나") {
			@Override
			public void print() {
				System.out.printf("%s님 반갑습니다!", name);
			}
		};
		obj1.print();
	}
}
