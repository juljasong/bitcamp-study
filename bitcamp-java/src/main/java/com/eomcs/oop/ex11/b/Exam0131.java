// 클래스의 종류 : non-static 중첩 클래스(nested class) 사용
package com.eomcs.oop.ex11.b;

import java.io.File;
import java.io.FilenameFilter;

public class Exam0131 {

  class JavaFilter implements FilenameFilter {
    public boolean accept(File dir, String name) {
      if (name.endsWith(".java")) 
        return true; 
      return false; 
    }
  }

  public static void main(String[] args) throws Exception {
    File dir = new File(".");
    JavaFilter javaFilter;
    // static 메서드에서는 인스턴스 멤버 사용 불가
    //javaFilter = new JavaFilter();
    
    // static 메서드에서 인스턴스 멤버 사용하려면 인스턴스 생성해야 한다
    Exam0131 obj = new Exam0131();
    // 이 인스턴스로 인스턴스 필드, 메서드, 중첩 클래스 사용 가능
    javaFilter = obj.new JavaFilter();
    String[] names = dir.list(javaFilter);
    for (String name : names) {
      System.out.println(name);
    }

  }
}







