// non-static nested class == inner class
package com.eomcs.oop.ex11.a;

// 특정 클래스 스태틱 멤버를 미리 선언하면, 그 멤버 사용 시 클래스 이름 작성할 필요 없음
import static com.eomcs.oop.ex11.a.Exam0112_X.*;

public class Exam0113 {
  
  public static void main(String[] args) {
    // 다른 클래스의 스태틱 멤버가 접근 가능하다면 언제든 사용할 수 있듯이 
    sValue = 100;
    // 그 클래스의 static nested class 또한 같은 방식으로 사용 가능
    A obj;
    obj = new A();
  }

}
