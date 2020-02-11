// stateless 방식에서 클라이언트 구분하고 결과 유지
package com.eomcs.net.ex04.stateless2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class CalcServer {
  public static void main(String[] args) throws Exception {
    System.out.println("서버 실행 중...");

    Map<Long, Integer> resultMap = new HashMap<>();
    ServerSocket ss = new ServerSocket(8888);

    while (true) {
      try (Socket socket = ss.accept();
          DataInputStream in = new DataInputStream(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

        Long clientId = in.readLong();
        // => 0 : 아직 클라이언트 아이디 없음
        // => x : 서버가 클라이언트에게 아이디 부여함

        String op = in.readUTF();
        int value = in.readInt();

        // 클라이언트를 위한 기존값 꺼내기
        int result = 0;
        Integer obj = resultMap.get(clientId);

        if (obj != null) {
          System.out.printf("%d 기존 고객 요청 처리\n", clientId);
          result = obj;
        } else {
          // 해당 클라이언트 방문 기록 없음 -> 새 클라이언트 아이디 발급
          clientId = System.currentTimeMillis();
          System.out.printf("%d 신규 고객 요청 처리\n", clientId);
        }

        switch (op) {
          case "+":
            result += value;
            break;
          case "-":
            result -= value;
            break;
          case "*":
            result *= value;
            break;
          case "/":
            result /= value;
            break;
        }
        out.writeLong(clientId);
        out.writeInt(result);
        out.flush();
        resultMap.put(clientId, result);
      }
      ss.close();
    }
  }
}


