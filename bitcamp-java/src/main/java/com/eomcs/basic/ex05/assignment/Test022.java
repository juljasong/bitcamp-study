package com.eomcs.basic.ex05.assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class Test022 {
  public static void main(String[] args) {

    ArrayList<Integer> list = new ArrayList<Integer>();
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    //int[] num = new int[5];
    
    Scanner sc = new Scanner(System.in);
    System.out.print("입력(숫자 5자리)? ");
    
    for(int i = 0 ; i < 5 ; i++) {
     list.add(sc.nextInt());
    }
    sc.close();
    
    for ( int i = 0 ; i < list.size() ; i++ ) {
      if (max < list.get(i))
        max = list.get(i);
    }
    
    for  ( int i = 0 ; i < list.size() ; i++ ) {
      if (min > list.get(i))
        min = list.get(i);
    }
    
    System.out.println("최소값 : " + min);
    System.out.println("최대값 : " + max);
  }
}
