package com.eomcs.util;

public class ArrayListTest {

  public static void main(String[] args) {
    ArrayList<String> a1 = new ArrayList<>();
    //ArrayList a2 = new ArrayList(100);
    a1.add("111");
    a1.add("222");
    a1.add("333");
    a1.add("444");
    a1.add("555");
    print(a1);
    System.out.println("-------");
    
    String oldValue = (String)a1.remove(0);
    System.out.printf("a1[0] : %s ==> %s \n", oldValue, a1.get(0));
    oldValue = (String)a1.set(0, "bbb");
    System.out.printf("a1[0] : %s ==> %s \n", oldValue, a1.set(0, "bbb"));
    a1.set(1, "set()");
    a1.set(5, "set()");
    System.out.println("-------");
    a1.add(5, "XXX");

    print(a1);
  }
  
  static void print(ArrayList<String> arr) { //size : [3] 길이는 고정적으로 변함!
    String[] list = arr.toArray(new String[] {});
    for (String e : list) {
      System.out.println(e);
    }
  }

}
