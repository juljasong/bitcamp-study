package com.ohoracs.basic.ex02;

// Annotation
// : 컴파일러나 JVM에게 지시하는 명령. 실행 중 추출하여 사용하는 특별한 데이터
public class Exam3 {
  public static void main(String[] args) {

    System.out.println("Annotation!");

  }
  
  @Override // <== 컴파일러에게 메서드 재정의를 알림
    public String toString() {
      return "okok";
    }
  
}