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
    // inner class의 생성자 호출 시, 바깥 클래스의 인스턴스 주소를 파라미터로 넘기지 말고, this로
    return this.new QueueIterator<>();
  }

  // non-static nested class = inner class
  class QueueIterator<T> implements Iterator<T> {

    Queue<T> queue;

    @SuppressWarnings("unchecked")
    public QueueIterator() {
      this.queue = (Queue<T>) Queue.this.clone(); // 바깥 클래스.this.
    }

    @Override
    public boolean hasNext() { // 다음 값 존재?
      return queue.size() > 0;
    }

    @Override
    public T next() { // 다음 값 리턴
      return queue.poll();
    }
  }

}
