package com.eomcs.basic.ex03;
// Literal

public class Exam22 {

  public static void main(String[] args) {
    
    //10진수 리터럴
    System.out.println(2_3500_0000);
    System.out.println(235_000_000);
    //System.out.println(_235_000_000);
    //System.out.println(235_000_000_);
    System.out.println(2_35_000_000);

    //8진수 리터럴
    System.out.println(0144);

    //2진수 리터럴
    System.out.println(0b01100100);
    System.out.println(0B01100100);
    System.out.println(0b0110_0100);
    System.out.println(0B0110_0100);
    //System.out.println(0b_0110_0100);
    //System.out.println(0B_0110_0100);

    //16진수 리터럴
    System.out.println(0x64);
    System.out.println(0x0064);
    //System.out.println(0x_64);
    //System.out.println(0x_0064);

  }
}