// String - 다형적 변수와 형변환, toString()
package com.eomcs.corelib.ex01;

public class Exam0141 {
  public static void main(String[] args) {

    Object obj = new String("Hello"); // 인스턴스 주소가 100이라 가정하자;

    String x1 = (String) obj; // x1 = 100
    String x2 = obj.toString(); // x2 = 100
    // 레퍼런스를 통해 메서드 호출 시, 원래 객체의 클래스에서 부터 메서드를 찾아 올라감.
    // obj가 가리키는 객체의 클래스가 String 클래스이기 때문에, obh.toString()은 String 클래스 부터 시작하여
    // 해당 메서드를 찾아 올라간다................. 당연?

    System.out.println(x1.toLowerCase());
    ((String) obj).toLowerCase();

    x2.toLowerCase();
    obj.toString().toLowerCase();

    if (x1 == x2) {
      System.out.println("x1 == x2");
    }
  }
}





