// BufferedInputStream 사용 후 - 데이터 읽는데 걸린 시간 측정
package com.eomcs.io.ex06;

public class Exam0310 {

  public static void main(String[] args) throws Exception {
    BufferedInputStream in = new BufferedInputStream("temp/test7.data");

    long startTime = System.currentTimeMillis(); // 밀리초

    int callCount = 0;

    while (true) {
      int b = in.read();
      if (b == -1)
        break;
      System.out.println("Exam0310.int b : " + b);
      callCount++; // 파일을 끝까지 읽는다.
    }

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);
    System.out.println(callCount);

    in.close();
  }

}
