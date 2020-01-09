package com.eomcs.util;

public class LinkedListTest {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    list.add("fff");
    list.add("ggg");
    
    //list.add(0, "xxx");
    list.remove(300);
    System.out.println(list.set(0, "111"));
    System.out.println("---");
    
    print(list);
    //System.out.println(list.get(-1));

  }
  
  static void print(LinkedList<String> list) {
    //String[] arr = list.toArray(new String[] {});
    String[] arr = list.toArray(new String[list.size]);
    for (Object value : arr) {
      System.out.println(value);
    }
  }
  
  

}
