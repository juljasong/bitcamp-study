package com.eomcs.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size;

  public int size() {
    return size;
  }

  public Iterator<E> iterator() {
    return this.new ListIterator<E>();
  }

  // not-static nested class = inner class
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
  
}
