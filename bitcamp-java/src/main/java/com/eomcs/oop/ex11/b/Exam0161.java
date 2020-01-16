// 클래스의 종류 : lambda
package com.eomcs.oop.ex11.b;

import java.io.File;

public class Exam0161 {

  public static void main(String[] args) throws Exception {

    File dir = new File(".");

    String[] names = dir.list((d, n) -> {
      if (n.endsWith(".java")) 
        return true; 
      return false; 
    }
        );

    for (String name : names) {
      System.out.println(name);
    }
  }

}







