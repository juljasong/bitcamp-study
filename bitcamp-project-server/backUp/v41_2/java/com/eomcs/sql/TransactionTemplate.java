package com.eomcs.sql;

public class TransactionTemplate {
  PlatformTransactionManager txManager;

  public TransactionTemplate(PlatformTransactionManager txManager) {
    this.txManager = txManager;
  }

  public Object execute(TransactionCallback action) throws Exception {

    txManager.beginTransaction();

    try { // 하나의 트랜잭션
      Object result = null;

      action.doInTransaction();

      txManager.commit();
      return result;

    } catch (Exception e) { // 예외 발생시 롤백
      txManager.rollback();
      throw e;
    }

  }

}
