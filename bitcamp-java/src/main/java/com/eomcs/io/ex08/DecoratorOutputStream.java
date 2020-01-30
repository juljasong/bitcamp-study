package com.eomcs.io.ex08;

import java.io.IOException;
import java.io.OutputStream;

public abstract class DecoratorOutputStream extends OutputStream {
  OutputStream 연결된_부품; // 실제 데이터를 받아들이는 놈

  public DecoratorOutputStream(OutputStream 부품) {
    // 확장시킬 기능은 다른 기능과 연결할 수 있도록 생성자에서 그 객체의 주소를 받아야 함
    this.연결된_부품 = 부품;
  }

  @Override
  public void write(int b) throws IOException {
    연결된_부품.write(b);
  }

  @Override
  public void close() throws IOException {
    연결된_부품.close();
  }
}
