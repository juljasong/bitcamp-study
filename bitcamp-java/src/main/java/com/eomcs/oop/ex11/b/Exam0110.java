// 클래스의 종류 : 패키지 멤버 클래스 사용
package com.eomcs.oop.ex11.b;

import java.io.File;

// 물론 Exam01_1 또한 패키지 멤버 클래스이다.
public class Exam0110 {

    public static void main(String[] args) throws Exception {
        File dir = new File("."); // 현재 폴더의 하위 폴더 및 파일의 이름 
        
        // File 클래스를 이용해 현재 폴더의 정보 알아냄 => OS의 기능을 이용하여 폴더 및 파일 정보를 다룸
        JavaFilter javaFilter = new JavaFilter();
        
        // 패키지 멤버 클래스의 인스턴스를 필터로 사용하여 디렉토리 안의 목록을 추출한다.
        String[] names = dir.list(javaFilter);
        for (String name : names) {
            System.out.println(name);
        }

    }

}







