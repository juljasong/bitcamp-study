// Wrapper 클래스 - auto-boxing/auto-unboxing 응용
package com.eomcs.corelib.ex01;

public class Exam0223 {
  
  static class Member {
    String name;
    String tel;
    
    @Override
    public String toString() {
      return name + ", " + tel;
    }
  }
  
  public static void main(String[] args) {
    int i = 100;
    Member member = new Member();
    member.name = "홍길동";
    member.tel = "010-1111-1111";
    String str = new String("Hello");
    print(100);
    print(member);
    printObject(100); // 파라미터 타입이 Object이면 자바 컴파일러는 오토 박싱 코드로 변환 ->Integer.valueOf(100)
    
    String v3 = new String("Hello");
    
    Object obj;
    obj = member;
    obj = str;
    obj = i;
    
    Integer obj2 = (Integer)obj;
    System.out.println(i);
    System.out.println(obj);
    
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






