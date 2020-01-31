package com.eomcs.util;

public abstract class AbstractList<E> implements List<E>{

  protected int size;

  public int size() {
    return size;
  }

  public Iterator<E> iterator() {
    // anonymous class = 하나의 인스턴스만 생성할 때, 익명 클래스 사용. 이름이 없고 생성자도 사용할 수 없음
    
    return new Iterator<E>() { // Iterator 인터페이스를 구현한 익명 클래스 -> 이름이 없어서 정의하자 마자 인스턴스 생성해야 함
      
      List<E> list;
      int cursor;
      
      { // 생성자를 만들 수 없기 때문에, 인스턴스 필드 초기화 시키기 위해 인스턴스 블록 사용
        this.list = (List<E>) AbstractList.this;
      }

      @Override
      public boolean hasNext() { // 다음 값 존재?
        return cursor < list.size();
      }

      @Override
      public E next() { // 다음 값 리턴
        return list.get(cursor++);
      }
      
    };
    
  }
}
