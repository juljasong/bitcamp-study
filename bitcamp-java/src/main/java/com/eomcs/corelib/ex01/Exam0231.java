// Wrapper 클래스 - wrapper 객체의 값 비교 
package com.eomcs.corelib.ex01;

public class Exam0231 {
  public static void main(String[] args) {
    Integer obj1 = Integer.valueOf(100); 
    Integer obj2 = 100; 
    System.out.println(obj1 == obj2); // true 
    // auto-boxing이나 valueOf()로 생성한 wrapper 객체는 constants pool에 하나만 생성되기 때문에
    // 값 비교 시 == 연산자 사용하여 인스턴스 주소로 비교 가능

    Integer obj3 = new Integer(100); 
    Integer obj4 = new Integer(100); 
    System.out.println(obj3 == obj4); // false
    System.out.println(obj3.equals(obj4));; // true 
    // 인스턴스가 따로 생성된 wrapper 객체는 값이 같더라도 == 사용 불가
    
    // 결론 : 
    // wrapper 객체를 생성할 때는 new가 아닌 valueOf나 auto-boxing 기능을 이용
    // => 값 비교할 때 == 연산자 비교 가능
    
    // wrapper 클래스는 모두 String 클래스 같이 상속받은 Object의 equlas() 오버라이딩하였다
    // -> 인스턴스 비교하는 것이 아닌 값이 같은지를 비교
   

  }
}






