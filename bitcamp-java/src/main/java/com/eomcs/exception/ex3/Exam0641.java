// 예외 처리 후 마무리 작업 - try-with-resources
package com.eomcs.exception.ex3;

public class Exam0641 {

  static class B implements AutoCloseable {

    public void m(int value) throws Exception {
      if (value < 0) {
        throw new Exception("음수입니다.");
      }
      System.out.println("m() 호출");
    }

    @Override
    public void close() throws Exception {
      System.out.println("close() 호출");
    }
  }

  public static void main(String[] args) throws Exception {
    try (B obj = new B() /* 마지막 문장에는 ; 안붙여도 됨 */) {
      System.out.println("try 블록 실행...시작");
      obj.m(-100);
      System.out.println("try 블록 실행...종료");
      // 예외 발생 시, try{}를 나가기 전에 close() 호출됨
    } catch (Exception e) {
      System.out.println("예외 발생 : " + e.getMessage());
    }
  }
}
