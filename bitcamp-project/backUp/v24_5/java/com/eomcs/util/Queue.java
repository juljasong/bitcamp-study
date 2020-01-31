package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable{

  public void offer(E value) {     
    this.add(value); 
  }

  public E poll() {
    return (E) this.remove(0);
  }

  @Override
  public Queue<E> clone() {

    Queue<E> temp = new Queue<E>();

    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }

  public Iterator<E> iterator() {

    return new Iterator<E>() {
      Queue<E> queue  = (Queue<E>) Queue.this.clone(); // 바깥 클래스.this.

      @Override
      public boolean hasNext() { // 다음 값 존재?
        return queue.size() > 0;
      }

      @Override
      public E next() { // 다음 값 리턴
        return queue.poll();
      }
    };
  }

}
