// 클래스의 종류 : 패키지 멤버 클래스 사용
package com.eomcs.oop.ex11.b;

import java.io.File;

public class Exam0111 {

    public static void main(String[] args) throws Exception {
        File dir = new File("."); 
        // File 객체를 통해 지정된 위치에 있는 폴더나 파일의 이름 알아낸다
        
        JavaFilter javaFilter = new JavaFilter(); // .java 파일만 추출
        String[] names = dir.list(javaFilter);
        for (String name : names) {
            System.out.println(name);
        }

    }

}







