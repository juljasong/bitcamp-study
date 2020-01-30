// DataInputStream을 FileInputStream이나 ByteArrayInputStream에 붙일 수 있도록
// 기능을 변경한다. 즉 DataInputStream을 장신구(decorator)로 만든다.

// 가공만 하는 클래스
package com.eomcs.io.ex08;

import java.io.InputStream;

public class DataInputStream extends DecoratorInputStream {

  public DataInputStream(InputStream in) {
    super(in);
  }

  public String readUTF() throws Exception {
    // 생성자에서 받은 입력 객체의 read() 메서드를 사용하여 문자열 출력
    // 연결된 부품을 사용하여 데이터를 읽어 중간에서 String 객체로 가공한다.
    // => Data Processing Stream Class
    int size = 연결된_부품.read();
    byte[] bytes = new byte[size];
    연결된_부품.read(bytes);
    return new String(bytes, "UTF-8");
  }

  public int readInt() throws Exception {
    int value = 0;

    value = 연결된_부품.read() << 24;
    value += 연결된_부품.read() << 16;
    value += 연결된_부품.read() << 8;
    value += 연결된_부품.read();
    return value;
  }

  public long readLong() throws Exception {
    long value = 0;
    value += (long) 연결된_부품.read() << 56;
    value += (long) 연결된_부품.read() << 48;
    value += (long) 연결된_부품.read() << 40;
    value += (long) 연결된_부품.read() << 32;
    value += (long) 연결된_부품.read() << 24;
    value += (long) 연결된_부품.read() << 16;
    value += (long) 연결된_부품.read() << 8;
    value += 연결된_부품.read();
    return value;
  }

  public boolean readBoolean() throws Exception {
    if (연결된_부품.read() == 1)
      return true;
    else
      return false;
  }

}


