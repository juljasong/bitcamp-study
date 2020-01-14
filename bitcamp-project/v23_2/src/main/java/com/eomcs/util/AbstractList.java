package com.eomcs.util;

// Generalization 1단계 : ArrayList-LinkedList 간 공통 분모 추출하여 수퍼 클래스 정의

// Generalization 2단계 : 직접 인스턴스를 생성하지 못하도록 막아야 한다 -> 추상 클래스(abstract class)
//  - 서브 클래스에서 구현할 메서드를 일반 메서드로 정의하면, 서브 클래스 정의하는 개발자가 해당 메서드를
//    오버라이딩 한다는 보장을 하지 못함.
//  - 상속 받는 메서드 중 반드시 서브 클래스에서 오버라이딩 해야할 메서드라면 문법으로 표시
//  => 추상 메서드 - 추상 메서드의 오버라이딩은 선택이 아닌 필수(컴파일 오류)
public abstract class AbstractList<E> {
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
