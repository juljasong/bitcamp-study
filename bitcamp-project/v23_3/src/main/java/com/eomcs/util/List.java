package com.eomcs.util;

// 목록 객체 사용 규칙 따로 정의
//  interface 규칙명 { ... }
public interface List<E> {

  // 사용 규칙(호출 메서드 시그너처 형식)이기 때문에 모든 메서드는 추상 메서드
  // public abstract returnType methodName(Parameter ...);
  // [public] [abstract] returnType methodName(Parameter ...);

  public abstract void add(E e);

  /*public*/ abstract void add(int index, E e);

  public /*abstract*/ E get(int index);

  /*public abstract*/ E set(int index, E e);

  E remove(int index);

  Object[] toArray();

  E[] toArray(E[] arr);

}
