// 변수 초기화 - 자동 초기화
package com.eomcs.oop.ex03;

import java.sql.Date;

public class Exam0510 {
    static class A {
        static int a;
        int b;
        static String str;
        static Date date;
        String str2;
        Date date2;
    }
    public static void main(String[] args) {
        int c;
        
        // 클래스 변수는 생성되는 순간 0으로 자동 초기화 된다.
        // -> 정수(byte, short, int, long, char) : 0
        // -> 부동소수점(float, double) : 0.0
        // -> 논리 (boolean) : false
        //
        System.out.printf("%d %s %s \n", A.a, A.str, A.date);
        
        A obj1 = new A();
        
        // 인스턴스 변수는 생성되는 순간 0으로 자동 초기화 된다. 
        System.out.printf("%d %s %s \n", obj1.b, obj1.str2, obj1.date2);
        
        // 로컬 변수는 자동 초기화되지 않는다.
        // 반드시 사용전에 값을 저장해야 한다.
        //System.out.println(c); // 컴파일 오류!
    } 
}




