package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStream extends FileInputStream {
  byte[] buf = new byte[50]; // 8192
  int size; // 배열에 저장되어 있는 바이트의 수 : 1 ~ 8192
  int cursor; // 바이트 읽은 배열의 위치 : 0 ~ 8191

  public BufferedInputStream(String filename) throws Exception {
    super(filename);
  }

  @Override
  public int read() throws IOException {

    System.out.println("--------strat(size, cursor)---------- : " + size + ", " + cursor);

    if (size == cursor) { // 버퍼가 다차면
      if ((size = super.read(buf)) == -1) { // buf에 데이터 받아오다가, 더이상 데이터 없으면 -1
        System.out.println("size = super.read(buf) = " + (size = super.read(buf)));
        return -1;
      }
      cursor = 0;
      System.out.println("size : " + size + ", cursor : " + cursor);
    }
    System.out.println();
    return buf[cursor++] & 0x000000ff;
  }

  @Override
  public int read(byte[] buf) throws IOException {
    int i = 0;
    for (; i < buf.length; i++) {
      // 1바이트를 읽어서 파라미터로 받은 바이트 배열에 채운다.
      int b = this.read();
      if (b == -1) {
        // 바이트 배열을 다 채우기도 전에 읽을 데이터가 없다면 읽기를 멈춘다.
        break;
      }
      buf[i] = (byte) b;
    }
    return i; // 지금까지 읽은 데이터의 수를 리턴한다.
  }
}


