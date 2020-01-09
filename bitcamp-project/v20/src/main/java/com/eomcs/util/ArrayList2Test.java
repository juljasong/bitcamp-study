package com.eomcs.util;

public class ArrayList2Test {

  public static void main(String[] args) {
    ArrayList2<String> a1 = new ArrayList2<>();
    
    a1.add("aaa");
    a1.add("bbb");
    a1.add("ccc");
    a1.add("ddd");
    print(a1);
    System.out.println("----");
    a1.remove(0);
    print(a1);
    System.out.println("----");
    a1.add("eee");
    System.out.println(a1.set(3, "set"));
    a1.set(3, "set");
    print(a1);
    System.out.println("----");
    
  }
  public static void print(ArrayList2<String> arr) {
    String[] list = arr.toArray(new String[] {});
    for(String s : list) {
      System.out.println(s);
    }
    /*
    for (int i = 0 ; i < arr.size() ; i++) {
      System.out.println(arr.get(i));
    }
    */
  }
}
