package com.eomcs.util;

// 추상 메서드를 인터페이스로 분리 후, 다음과 같이 해당 인터페이스 규칙 추가
// => List에 선언된 모든 추상 메서드 반드시 구현(정의)해야 함
// 구현(inplements)? 
//      메서드의 몸체(body) 정의 = 메서드에 코드 정의
//      메서드가 할 일 코드로 정의
//      ex) abstract void m1(); <- 추상 메서드
//          void m1() { ... }
public abstract class AbstractList<E> implements List<E>{
  protected int size;

  public int size() {
    return size;
  }

  public abstract void add(E e);

  public abstract void add(int index, E e);

  public abstract E get(int index);

  public abstract E set(int index, E e);

  public abstract E remove(int index);

  public abstract Object[] toArray();

  public abstract E[] toArray(E[] arr);

}
