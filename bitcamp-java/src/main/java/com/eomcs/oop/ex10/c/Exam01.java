// 템플릿 메서드를 구현한 클래스 사용
package com.eomcs.oop.ex10.c;

public class Exam01 {

    public static void main(String[] args) {
        Restautant r = new Restautant();
        Farm f = new Farm();
        
        // 레스토랑이나 농장 거축의 기본 흐름은 이미 정해져 있다.
        // 단지 착수와 완료에 대한 것만 다르다.
        work(r);
        System.out.println("---------------------");
        work(f);

    }
    
    static void work(Building obj) {
      // 레스토랑이나 농장 건축 기본 흐름은 이미 수퍼 클래스에 정의되어 있다.
      // 착수와 완료는 서브 클래스 마다 다르다
      obj.build();
    }

}
