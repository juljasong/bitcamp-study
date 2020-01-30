package com.eomcs.io.ex08;

import java.io.IOException;
import java.io.InputStream;

public abstract class DecoratorInputStream extends InputStream {
  InputStream 연결된_부품; // 실제 데이터를 받아들이는 놈

  public DecoratorInputStream(InputStream 부품) {
    // 확장시킬 기능은 다른 기능과 연결할 수 있도록 생성자에서 그 객체의 주소를 받아야 함
    this.연결된_부품 = 부품;
  }

  @Override
  public int read() throws IOException {
    // read() 메서드 호출되면 연결된 다른 부품의 read() 실행
    return 연결된_부품.read();
  }

  @Override
  public void close() throws IOException {
    연결된_부품.close();
  }
}
