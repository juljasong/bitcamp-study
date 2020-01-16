package com.eomcs.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size;

  public int size() {
    return size;
  }

  public Iterator<E> iterator() {
    // local class : 특정 메서드 안에서만 사용하는 중첩 클래스라면 그 메서드 안에 둔다
    class ListIterator<T> implements Iterator<T> { //inner 클래스의 제너럴은 바깥 클래스와 구분하여 사용

      List<T> list;
      int cursor;

      @SuppressWarnings("unchecked")
      public ListIterator() {
        this.list = (List<T>) AbstractList.this;
      }

      @Override
      public boolean hasNext() { // 다음 값 존재?
        return cursor < list.size();
      }

      @Override
      public T next() { // 다음 값 리턴
        return list.get(cursor++);
      }
    }
    // 로컬 클래스는 인스턴스 멤버가 아니기 때문에 인스턴스 주소(this.)를 알려줘서는 안된다
    return new ListIterator<E>();
  }
}
