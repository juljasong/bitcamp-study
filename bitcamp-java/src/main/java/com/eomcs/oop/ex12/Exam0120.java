// 람다(lambda) - body
package com.eomcs.oop.ex12;

public class Exam0120 {

	static interface Player {
		void play();
	}


	public static void main(String[] args) {

		// 1. 메서드 몸체에 문장 하나 있을 때, 중괄호 생략 가능
		Player p1 = () -> System.out.println("p1");
		p1.play();

		Player p2 = () -> {
			System.out.println("p2");
		};
		p2.play();

	}

}


