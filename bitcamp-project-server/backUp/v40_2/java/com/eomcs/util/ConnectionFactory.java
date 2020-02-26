package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import com.eomcs.sql.ConnectionProxy;

public class ConnectionFactory {

  String jdbcUrl;
  String userName;
  String password;

  ThreadLocal<Connection> connectionLocal = new ThreadLocal<>();

  public ConnectionFactory(String jdbcUrl, String userName, String password) {
    this.jdbcUrl = jdbcUrl;
    this.userName = userName;
    this.password = password;
  }

  public Connection getConnection() throws Exception {

    Connection con = connectionLocal.get();

    if (con != null) { // 스레드에 보관된 Connection 객체 리턴
      return con;
    }

    con = new ConnectionProxy(DriverManager.getConnection(jdbcUrl, userName, password));
    connectionLocal.set(con);
    return con;
  }

  public Connection removeConnection() {
    Connection con = connectionLocal.get();
    if (con != null) {
      connectionLocal.remove();
      System.out.println("스레드에 보관된 Connection 객체 제거 완료");
    }
    return con;
  }

}
