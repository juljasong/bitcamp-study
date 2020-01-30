// DataOutputStream을 이용하여 객체 출력 - 인스턴스의 값을 출력
package com.eomcs.io.ex08;

import java.io.FileOutputStream;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    // 다중 상속 불가 -> 여러 클래스에 있는 기능 조합하기 위해서는 별도의 클래스 생성하여 기존 코드 복사해야 함
    // => 코드 중복의 문제, 상황에 따라 다양한 조합을 수행하다 보면, 중복 코드를 갖는 클래스가 많이 생성될 것
    // -> 유지 보수 어려움

    // Decorator Design Pattern
    // => 확장 기능을 장식품(decorator) 처럼 붙였다 똈다 할 수 있게 함
    // - 모든 부품은 같은 유형
    // - 즉, 같은 부모의 자식이 되게 함
    // - 다른 부품을 붙일 수 있도록 생성자를 만든다.
    FileOutputStream fileOut = new FileOutputStream("temp/test6.data");

    // 부품 추가
    // 기존의 FileOutputStream 객체에 String,int,boolean 값을 출력하는
    // 장신구/보조장치/플러그인(decorator)을 장착한다.
    // => 사용할 부품 생성자 파라미터로 전달
    DataOutputStream out = new DataOutputStream(fileOut);

    Member member = new Member();
    member.name = "AB가각간";
    member.age = 27;
    member.gender = true;

    // 장신구/보조장치/플러그인(decorator)를 사용하여 String,int,boolean 값을 출력한다.
    out.writeUTF(member.name);
    out.writeInt(member.age);
    out.writeBoolean(member.gender);

    out.close();

    System.out.println("데이터 출력 완료!");

  }

}
