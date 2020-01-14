package com.eomcs.util;

public class Queue<E> extends LinkedList<Object> implements Cloneable{

  public void offer(E value) { // add
    this.add(value); // 노드 추가하면서 더해짐
  }

  @SuppressWarnings("unchecked")
  public E poll() {
    return (E) this.remove(0);
  }

  /*
  // Object의 shallow copy : 
  // Queue에서 poll()을 수행하면 first 노드를 삭제하게 되고, 이 때 원본 객체의 노드의 next 정보 변경
  // -> 복제를 다시 수행하면, 원본 노드의 링크 정보가 제거되었기 때문에 제대로 수행 불가
  // => 원본 객체가 사용하는 노드 함께 복제해야 함(Deep copy)
  @Override
  public Queue clone() {
    try {
    return (Queue) super.clone();
    } catch(CloneNotSupportedException e) {
      System.out.println(e);
      return null;
    }
  }
   */
  //  Deep Copy 수행
  // => 스택은 배열을 복사하면 되기 때문에, 기존의 shallow copy 수행 후 배열을 따로 복사했지만
  // => LinkedList의 경우 노드와 노드를 연결해야하기 때문에 shallow copy만 수행해서는 안되고,
  //    다음과 같이 새 Queue를 만들어 기존 Queue에 저장된 값을 꺼내 저장해야 함.
  @Override
  public Queue<E> clone() {

    Queue<E> temp = new Queue();
    for (int i = 0 ; i < this.size() ; i++) {
      temp.offer((E) this.get(i));
    }
    return temp;
  }

}
