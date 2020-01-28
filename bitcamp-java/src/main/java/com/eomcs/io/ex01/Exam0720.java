// 활용 - 지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름 출력
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0720 {

  public static void main(String[] args) throws Exception {

    File dir = new File("temp");
    deleteFile(dir);

    System.out.println("삭제하였습니다.");

  }

  static void deleteFile(File dir) {
    File[] files = dir.listFiles();

    for (File file : files) {
      if (file.isDirectory()) {
        deleteFile(file);
      } else {
        file.delete(); // 파일 삭제
      }
    }
    dir.delete(); // 디렉토리 삭제
  }

}

