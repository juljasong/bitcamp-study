package com.eomcs.util;

public class StackIterator<E> implements Iterator<E> {

  Stack<E> stack;

  public StackIterator(Stack<E> stack) {
    this.stack = stack.clone();
  }

  @Override
  public boolean hasNext() { // 다음 값 존재?
    return !stack.empty(); // 비어 있지 않으면 true
  }

  @Override
  public E next() { // 다음 값 리턴
    return stack.pop();

  }

}
