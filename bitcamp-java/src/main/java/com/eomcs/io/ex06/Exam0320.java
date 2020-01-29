// BufferedInputStream과 BufferedOutputStream을 사용하여 파일 복사 및 시간 측정
package com.eomcs.io.ex06;

public class Exam0320 {

  public static void main(String[] args) throws Exception {
    BufferedInputStream in = new BufferedInputStream("temp/jls11.pdf");
    BufferedOutputStream out = new BufferedOutputStream("temp/jls11_4.pdf");

    int b;

    long startTime = System.currentTimeMillis(); // 밀리초

    while ((b = in.read()) != -1) {
      out.write(b);
    }
    // out.flush(); // 버퍼에 방출되지 않고 버퍼에 남아있는 데이터 출력

    long endTime = System.currentTimeMillis();

    System.out.println(endTime - startTime);

    in.close();
    out.close();
  }

}
