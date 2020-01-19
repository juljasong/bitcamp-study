// local class - 로컬 클래스가 로컬 변수를 조회용으로만 사용하는 이유?
package com.eomcs.oop.ex11.a;

public class Exam0360 {


  public static void main(final String[] args) {
    final Exam0360 obj = new Exam0360();
    final Runner r = obj.createRunner("홍길동");
    // createRunner()의 리턴 값은
    // 이 메서드에 선언된 로컬 클래스인 A의 객체이다.
    // A 객체는 Runner 규칙에 따라 만들었기 때문에
    // Runner 레퍼런스에 저장할 수 있다.
    // 이 레퍼런스를 사용하여 A 객체의 run() 메서드를 호출해 보자!
    r.run();

    // 로컬 클래스의 객체가 로컬 변수의 값을 조회용으로만 사용하는 이유?
    // => 위의 코드에서 createRunner() 호출이 끝나면 이 메서드가 실행되는 동안
    // 생성되었던 모든 로컬 변수는 스택 메모리에서 제거된다.
    // 즉 createRunner()의 name 파라미터가 제거된다는 것이다.
  }

  Runner createRunner(final String name) {
    // Exam0360 객체 주소를 받는 내장 변수 this가 있다.
    class A implements Runner {
      @Override
      public void run() {
        // 바깥 메서드의 로컬 변수는 호출 완료되는 순간 스택에서 제거되기 때문에
        // 로컬 클래스의 객체에서 사용할 수 없다.
        // => 컴파일러가 바깥 메서드의 로컬 변수 값을 저장할 필드를 클래스에 추가
        // 또한 로컬 변수의 값을 받는 생성자를 만듬
        // => run() 호출하는 시점에는 A 로컬 객체에 name 변수의 값이 들어있어 로컬 변수 사용 가능
        System.out.printf("%s님이 달립니다!", name); // => System.out.printf("%s님이 달립니다!", this.paraName);
      }
    }
    return new A(); // => new A(this);
  }
}


interface Runner {
  void run();
}
