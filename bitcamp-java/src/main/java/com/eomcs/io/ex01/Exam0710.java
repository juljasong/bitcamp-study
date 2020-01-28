// 활용 - 지정한 폴더 및 그 하위 폴더까지 모두 검색하여 파일 및 디렉토리 이름을 출력
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0710 {


  public static void main(String[] args) throws Exception {

    // /user/user/git/bitcamp-study
    // src/
    // main/
    // java/
    // com/
    // Hello.java
    // build.gradle
    // ...
    int level = 0;
    File dir = new File(".");
    System.out.println(dir.getCanonicalPath());

    printList(dir, level);

  }

  static void printList(File dir, int level) {

    File[] files = dir.listFiles(); // 현재 디렉토리의 하위 파일 / 디렉토리 목록

    for (File file : files) {
      printIndent(level);
      if (file.isDirectory() && !file.isHidden()) {
        System.out.printf("%s/\n", file.getName());
        printList(file, level + 1);
      } else {
        System.out.print("\\-- ");
        System.out.printf("%s\n", file.getName());
      }
    }
  }

  static void printIndent(int level) {
    for (int i = 0; i < level; i++) {
      System.out.print("  ");
    }
  }
}

