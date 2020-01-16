package com.eomcs.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size;

  public int size() {
    return size;
  }

  public Iterator<E> iterator() {
    return new ListIterator<E>(this);
  }

  static class ListIterator<E> implements Iterator<E> {
    
    List<E> list;
    int cursor;
    
    public ListIterator(List<E> list) {
      this.list = list;
    }
    
    @Override
    public boolean hasNext() { // 다음 값 존재?
      return cursor < list.size();
    }
    
    @Override
    public E next() { // 다음 값 리턴
      return list.get(cursor++);
    }
  }
  
}
