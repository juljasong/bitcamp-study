// String - 다형적 변수와 형변환, toString()
package com.eomcs.corelib.ex01;

public class Exam0142 {
  public static void main(String[] args) {

    // obj를 통해 원래 인스턴스 메서드를 호출하고 싶다면 형변환해야 함
    
    Object obj = new String("Hello"); 
    
    String x1 = (String) obj; // x1 = Hello
    System.out.println(x1.toLowerCase());
    
    System.out.println(((String) obj).toLowerCase());

    String x2 = obj.toString().toUpperCase();
    System.out.println(x2);

  }
}





