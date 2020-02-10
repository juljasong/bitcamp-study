// stateful
package com.eomcs.net.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0110 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try (Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      System.out.println("서버 연결");
      String name = null;
      do {
        System.out.print("이름? ");
        name = sc.nextLine();

        out.println(name);
        out.flush();

        String str = in.readLine();
        System.out.println(str);

      } while (!name.equalsIgnoreCase("quit"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    sc.close();
  }
}


