package com.eomcs.sql;

public class TransactionTemplate {

  PlatformTransactionManager txManager;

  public TransactionTemplate(PlatformTransactionManager txManager) {
    this.txManager = txManager;
  }

  public Object execute(TransactionCallback action) throws Exception {
    // 이 메서드는 반복적으로 실행하는 코드를 정의한 것이다.
    // 반복 코드 안에서 특별하게 수행할 작업은 파라미터로 받는다.
    // 파라미터로 받은 객체를 실행 코드의 틀(템플릿) 안에서 실행한다.
    //
    txManager.beginTransaction();

    try {
      Object result = null; // 트랜잭션을 수행한 후 리턴할 결과를 담을 변수
      result = action.doInTransaction(); // 트랜잭션으로 묶인 작업들
      txManager.commit(); // 예외가 발생하지 않고 정상적으로 실행되었으면 수행한 작업을 적용한다.
      return result;// 트랜잭션 작업 결과를 리턴한다.

    } catch (Exception e) {
      txManager.rollback(); // 예외가 발생하면 지금까지 한 작업을 취소한다.
      throw e; // 발생된 예외는 이 메서드를 호출한 쪽에 그대로 전달한다.
    }
  }
}
