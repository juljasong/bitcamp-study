public class Exam01 {
    public static void main(String[] args) {
        C obj = new C();
    }
}

class A /*extends Object*/ {
    int v1;
    A() {  // 4.서브 클래스 B 생성자에 리턴
    System.out.println("A() 생성자");
    }
}

class B extends A {
    int v2;
    B() {  // 5.서브 클래스 C 생성자에 리턴
        super();  // 3. 수퍼 클래스 A 생성자 호출
        System.out.println("B() 생성자");
    }
}

class C extends B {  // 1.호출!
    int v3;
    C() {  // 6.실행
        super();  // 2.수퍼 클래스 B 생성자 호출
        System.out.println("C() 생성자");
    }
}