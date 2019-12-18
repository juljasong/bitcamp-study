package com.eomcs.basic.ex06.assignment;

public class Test02 {

  public static void main(String[] args) {
    
    int a = Console.inputInt();
    
    int i = 0;
    int j = 0;
    
    while (i++ < a) {
      while (j++ < i) {
        System.out.print("*");
        //j++;
      } 
      System.out.println();
      //i++;
      j = 0;
    }
    //i = 0;
    i--;
    
    while (--i > 0) {
      while (j++ < i) {
        System.out.print("*");
      }
      System.out.println();
      j = 0;
    }
    
    /*
    while (i++ < a-1) {
      while (j++ < a-i) {
        System.out.print("*");
        //j++;
      } 
      System.out.println();
      //i++;
      j = 0;
    }
    */
  }
}
