package com.eomcs.sql;

public interface TransactionCallback {
  Object doInTransaction() throws Exception;

}
