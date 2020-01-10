// Wrapper 클래스 - auto-boxing/auto-unboxing 응용
package com.eomcs.corelib.ex01;

public class Exam0224 {
  
  static class Member {
    String name;
    String tel;
    
    @Override
    public String toString() {
      return name + ", " + tel;
    }
  }
  
  public static void main(String[] args) {

    
    // 오토박싱/언박싱이 없으면 print() 처럼 primitive data type과 클래스의 인스턴스를 구분하여 메서드를 정의해야 함
    print(100);
    print(new Member());
    
    // 오토 박싱, 오토 언박싱 기능으로 한 개의 메서드로 primitive data type과 클래스를 모두 처리할 수 있음
    printObject(100); 
    
  }
  
  static void print(int i) {
    System.out.print("정수 : ");
    System.out.println(i);
  }
  
  static void print(Member m) {
    System.out.print("회원 : ");
    System.out.println(m);
  }
  
  static void printObject(Object o) {
    System.out.println(o);
  }
}






