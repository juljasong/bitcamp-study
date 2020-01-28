// 활용 - 클래스 파일 이름 출력 시, 패키지 이름 포함
package com.eomcs.io.ex01;

import java.io.File;
import java.io.FileFilter;

public class Exam0731 {


  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printList(dir, "");
  }

  static void printList(File dir, String packageName) {

    File[] files = dir.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        if (pathname.isHidden()) {
          return false;
        }
        if (pathname.getName().contains("$")) {
          return false;
        }
        if (pathname.isDirectory()
            || (pathname.isFile() && pathname.getName().endsWith(".class"))) {
          return true;
        }
        return false;
      }
    });

    if (packageName.length() > 0) { // packageName 길이 0이하 일 때, . 안붙임
      packageName += ".";
    }

    for (File file : files) {
      if (file.isDirectory()) {
        printList(file, packageName + file.getName()); // 디렉토리일 때, 디렉토리 주고 재탐색
      } else {
        System.out.println(packageName + file.getName().replace(".class", ""));
      }
    }
  }
}

