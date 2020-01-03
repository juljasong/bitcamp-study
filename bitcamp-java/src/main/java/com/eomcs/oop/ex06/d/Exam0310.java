// Object 클래스의 메서드를 오버라이딩 하기 - equals()
package com.eomcs.oop.ex06.d;

public class Exam0310 {

  static class Member /*extends Object */{
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  public static void main(String[] args) {
    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("홍길동", 20);

    System.out.println("m1 == m2");
    // equals() : 두 개의 인스턴스가 같은 인스턴스인지 비교. ==와 동일하게 동작
    // 이 메소드 또한 Object에 정의된 메소드 -> Object의 메소드 사용 가능
    // Object.equals()는 인스턴스를 비교
    System.out.println(m1.equals(m2)); // false
    
    System.out.println("---------------");
    
    // String.equals()는 리터럴을 비교
    String s1 = new String("Hello");
    String s2 = new String("Hello");
    System.out.println(s1 == s2); // false (인스턴스)
    System.out.println(s1.equals(s2)); // true (리터럴)

    // Member의 내용이 같은지 비교하고 싶은가?
    // => 이럴 때 "오버라이딩"을 사용하는 것이다.
    // => 즉 Object로부터 상속 받은 메서드가 Member 클래스에 맞지 않다.
    //    그럼 Member 클래스에 맞게끔 재정의하면 되는 것이다.
    // 다음 Exam0320를 보라!

  }
}