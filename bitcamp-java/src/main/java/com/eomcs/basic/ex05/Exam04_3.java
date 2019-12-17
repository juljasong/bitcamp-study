// 비트 이동 연산자 : >>, >>>, << 
package com.eomcs.basic.ex05;

public class Exam04_3 {
    public static void main(String[] args) {
      // >> 비트 이동 연산자 사용법
   
      int i = 1; 
      
      // 0000 0000 0000 0000 0000 0000 0000 0001 = 1
      System.out.println(i << 1);
      // 0000 0000 0000 0000 0000 0000 0000 0010 = 2
      System.out.println(i << 2);
      // 0000 0000 0000 0000 0000 0000 0000 0100 = 4
      System.out.println(i << 3);
      // 0000 0000 0000 0000 0000 0000 0000 1000 = 8
      System.out.println(i << 4);
      // 0000 0000 0000 0000 0000 0000 0001 0000 = 16
      
      i = 0b0000_1011; // 11
      System.out.println(i << 1); // 22 => 0001_0110
      System.out.println(i << 2); // 44 => 0010_1100
      System.out.println(i << 3); // 88 => 0101_1000
      
      
      i = 0b01101001; // 105
      System.out.println(i); 
      System.out.println(i >> 1); // 0011_0100|1 => 52
      System.out.println(i >> 2); // 00011_010|0 => 26
      System.out.println(i >> 3); // 0000_1101|0 => 13
      System.out.println(i >> 4); // 0000_0110|1 => 6

      
      // 음수를 이동 : >>> 무조건 1로 채운다
      i = 0b11111111_11111111_11111111_10101001; // -87
      System.out.println(i); 
      System.out.println(i >>> 1); 
      
      System.out.println(i >>> 2); 
      // 11_11111111_11111111_11111111_101010|01 => 1073741802
      
      System.out.println(i >>> 3); 
      // 111_11111111_11111111_11111111_10101|001 => 536870901
      
      System.out.println(i >>> 4);
      // 1111_11111111_11111111_11111111_1010|1001 => 268435450
    }
    

}
