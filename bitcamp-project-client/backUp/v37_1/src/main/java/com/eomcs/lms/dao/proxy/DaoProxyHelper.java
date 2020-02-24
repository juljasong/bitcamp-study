package com.eomcs.lms.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DaoProxyHelper {

  String host;
  int port;

  // DaoProxy가 서버와 통신할 때 필요한 준비 작업 수행
  // => 서버와 연결한 후, 입출력 스트림 준비 -> 파라미터로 넘겨받은 작업 객체 실행
  public DaoProxyHelper(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public Object request(Worker worker) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      return worker.execute(in, out);
    }
  }
}
