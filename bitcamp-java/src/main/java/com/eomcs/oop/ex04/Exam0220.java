// 인스턴스 메서드와 클래스 메서드의 활용 - wrapper 클래스 
package com.eomcs.oop.ex04;

public class Exam0220 {
  public static void main(String[] args) throws Exception {
    //Integer i1 = new Integer(100);
    //Integer i2 = new Integer(200);
    //Integer i3 = new Integer(300);
            /* 이렇게! */
    Integer i1 = Integer.valueOf(100);
    Integer i2 = Integer.valueOf(200);
    Integer i3 = Integer.valueOf(300);
    
    // 인스턴스 메서드 사용
    System.out.println(i2.compareTo(i1)); // 1
    System.out.println(i2.compareTo(i3)); // -1

    int v1 = i2.intValue();
    System.out.println(v1); // 200

    // 스태틱 메서드 = 클래스 메서드 사용
    int v2 = Integer.parseInt("1280");
    String s1 = Integer.toBinaryString(77);
    String s2 = Integer.toOctalString(77);
    String s3 = Integer.toHexString(77);
    System.out.printf("77 = %s, %s, %s\n", s1, s2, s3); // 77 = 1001101, 115, 4d

    Integer x1 = Integer.valueOf("44"); // 문자열에 있는 수를 10진수로 간주한다.
    Integer x2 = Integer.valueOf("44", 16); // 16진수라고 지정한다.
    System.out.printf("%d, %d\n", x1, x2); // 44, 68

    float f = Float.parseFloat("3.14f");
    boolean b = Boolean.parseBoolean("true");
    System.out.printf("%f, %b\n", f, b); // 3.140000, true

  }
}





