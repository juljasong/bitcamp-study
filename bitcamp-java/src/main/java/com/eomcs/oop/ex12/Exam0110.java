// 람다(lambda) - 익명 클래스
package com.eomcs.oop.ex12;

public class Exam0110 {

	static interface Player {
		void play();
	}


	public static void main(String[] args) {

		/* 로컬 클래스 */

		class MyPlayer implements Player {
			@Override
			public void play() {
				System.out.println("실행");
			}
		}
		Player p1 = new MyPlayer();
		p1.play();

	}

}


