package com.eomcs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

  String jdbcUrl;
  String userName;
  String password;

  public ConnectionFactory(String jdbcUrl, String userName, String password) {
    this.jdbcUrl = jdbcUrl;
    this.userName = userName;
    this.password = password;
  }

  public Connection getConnection() throws Exception {
    return DriverManager.getConnection(jdbcUrl, userName, password);
  }

}
