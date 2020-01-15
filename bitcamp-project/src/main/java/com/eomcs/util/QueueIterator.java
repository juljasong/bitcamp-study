package com.eomcs.util;

public class QueueIterator<E> implements Iterator<E> {

  Queue<E> queue;

  public QueueIterator(Queue<E> queue) {
    this.queue = queue.clone();
  }

  @Override
  public boolean hasNext() { // 다음 값 존재?
    return queue.size() > 0;
  }

  @Override
  public E next() { // 다음 값 리턴
    return queue.poll();
  }
}
