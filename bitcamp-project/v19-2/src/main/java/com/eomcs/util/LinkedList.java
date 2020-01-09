package com.eomcs.util;

import java.lang.reflect.Array;

public class LinkedList<E> {
  Node<E> first;
  Node<E> last;
  int size;

  static class Node<T> {
    T value;
    Node<T> next;
  }
  
  public void add (E value) {

    Node<E> newNode = new Node<>();
    newNode.value = value; // 새로운 노드 newNode 추가

    if(first == null) { // 첫번 째 노드 비어있으면 last, first node 모두 newNode
      last = first = newNode;
    } else {
      last.next = newNode; // 마지막 노드 next에 newNode 추가
      last = newNode; // 마지막 노드에 newNode 추가
    }
    this.size++;
  }

  public void add (int index, E value) {
    if (index < 0 || index >= size) {
      return;
    }
    Node<E> newNode = new Node();
    newNode.value = value; // 추가할 값

    Node<E> cursor = first; 
    for (int i = 0 ; i < index - 1 ; i++) // 지정한 이전 index 까지
      cursor = cursor.next; // 커서에 다음 커서 주소 넣기
    
    if (index == 0) {
      newNode.next = first;
      first = newNode;
    } else {
    newNode.next = cursor.next;
    cursor.next = newNode;
    }
  this.size++;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    Node<E> cursor = first;
    for (int i = 0 ; i < index ; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    Node<E> cursor = first;
    for (int i = 0 ; i < index - 1 ; i++) {
      cursor = cursor.next;
    }
    Node<E> deletedNode = null;
    if(index == 0) {
      deletedNode = first;
      first = deletedNode.next;
    } else {
    deletedNode = cursor.next;
    cursor.next = deletedNode.next;
    }
    deletedNode.next = null; // 삭제할 노드의 next는 null
    size--;
    return deletedNode.value; // 삭제할 노드의 값은 리턴
  }
  
  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      return null;
    }
    Node<E> cursor = first;
    for (int i = 0 ; i < index ; i++) {
      cursor = cursor.next;
    }
    E oldValue = cursor.value;
    cursor.value = value;
    return oldValue;
  }
  
  public Object[] toArray() {
    Object[] arr = new Object[size];
    Node<E> cursor = first;
    for (int i = 0; i < size ; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < size ) {
      arr = (E[])Array.newInstance(arr.getClass().getComponentType(), size);
    }
    Node<E> cursor = first;
    for (int i = 0; i < size ; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }
    return arr;
  }
  
  public int size() {
    return this.size;
  }
  
}
