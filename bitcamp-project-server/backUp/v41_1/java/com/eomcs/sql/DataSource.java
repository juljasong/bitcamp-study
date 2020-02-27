package com.eomcs.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DataSource {

  String jdbcUrl;
  String userName;
  String password;

  ThreadLocal<Connection> connectionLocal = new ThreadLocal<>();
  ArrayList<Connection> conList = new ArrayList<>();

  public DataSource(String jdbcUrl, String userName, String password) {
    this.jdbcUrl = jdbcUrl;
    this.userName = userName;
    this.password = password;
  }

  public Connection getConnection() throws Exception {

    Connection con = connectionLocal.get();
    if (con != null) { // 스레드에 보관된 Connection 객체 리턴
      return con;
    }

    if (conList.size() > 0) { // 스레드에 보관된 Connection 객체가 없으면 기존에 반납한 객체가 있는지 검사
      con = conList.remove(0); // 있다면 반납 받은 객체
    } else {
      con = new ConnectionProxy(DriverManager.getConnection(jdbcUrl, userName, password)); // 없다면 새
                                                                                           // 객체 만들어
                                                                                           // 리턴
      System.out.println("새 Connection 객체 생성!");
    }
    connectionLocal.set(con);
    System.out.printf("DataSource : 현재 보관 중인 객체 %d개\n", conList.size());
    return con;
  }

  public Connection removeConnection() {
    Connection con = connectionLocal.get();
    if (con != null) {
      connectionLocal.remove();
      System.out.println("스레드에 보관된 Connection 객체 제거 완료");

      conList.add(con);
    }
    System.out.printf("DataSource : 현재 보관 중인 객체 %d개\n", conList.size());
    return con;
  }

  public void clean() {
    while (conList.size() > 0) {
      try {
        ((ConnectionProxy) conList.remove(0)).realClose();
      } catch (Exception e) {

      }
    }
  }

}
