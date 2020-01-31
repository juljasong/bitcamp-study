package com.eomcs.util;

public abstract class AbstractList<E> implements List<E>{
  
  protected int size;

  public int size() {
    return size;
  }
  
  public Iterator<E> iterator() {
    return new ListIterator<E>(this);
  }

}
