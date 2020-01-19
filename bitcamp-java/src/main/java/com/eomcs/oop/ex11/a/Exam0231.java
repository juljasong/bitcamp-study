// non-static nested class = inner class
package com.eomcs.oop.ex11.a;

public class Exam0231 {

	class Exam0231_X {

		class A {
			
			String name;
			int age;
			
			/* constructor */
			public A(final String name, final int age) {
				this.name = name;
				this.age = age;
			}
			
			void print() {
				System.out.println(name + ", " + age);
			}
		}

		int iValue;
		void im() {}

	}


	public static void main(final String[] args) {

		Exam0231 e1 = new Exam0231();
		Exam0231_X e2 = e1.new Exam0231_X();
		Exam0231_X.A e3 = e2.new A("길동", 19);
		e3.print();
		

	}
}
