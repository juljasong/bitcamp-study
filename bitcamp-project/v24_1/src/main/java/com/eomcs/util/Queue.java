package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable{

  public void offer(E value) {     
    this.add(value); 
  }

  @SuppressWarnings("unchecked")
  public E poll() {
    return (E) this.remove(0);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Queue<E> clone() {

    Queue<E> temp = new Queue<E>();

    for (int i = 0; i < this.size(); i++) {
      temp.offer(this.get(i));
    }
    return temp;
  }

    public Iterator<E> iterator() {
      return new QueueIterator<E>(this);
    }

  }
