// 디렉토리에 들어있는 파일(디렉토리) 목록을 꺼낼 때 필터 적용하기
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FilenameFilter;

public class Exam0610 {

  static class JavaFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir/* 부모 경로 */, String name/* 파일/디렉토리 이름 */) {
      // 이 메서드는 list()에서 호출한다.
      // 하위 파일이나 디렉토리를 찾을 때 마다 호출
      // 이 메서드는 파일이나 디렉토리를 리턴할 배열에 포함시킬지 말지의 여부
      // true -> 배열에 포함 / false -> 배열 포함 X

      if (name.endsWith(".java"))
        // 파일, 디렉토리 이름이 .java로 끝나는 경우에만 리턴 배열에 포함
        return true; // 조회 결과에 포함시켜라!
      return false; // 조회 결과에서 제외하라!
    }
  }

  public static void main(String[] args) throws Exception {
    File dir = new File(".");

    // => 확장자가 .java 인 파일의 이름만 추출하기
    // 1) 필터 준비
    JavaFilter javaFilter = new JavaFilter();

    // 2) 필터를 사용하여 디렉토리의 목록을 가져오기
    String[] names = dir.list(javaFilter);

    for (String name : names) {
      System.out.println(name);
    }
    // 문제점 :
    // - temp.java는 디렉토리 -> 현재 필터는 파일명으로만 검사하여 파일인지 디렉토리인지 여부는 검사하지 않음.
  }

}


