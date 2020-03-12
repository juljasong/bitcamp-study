package com.eomcs.reflect.ex06.d;

import java.lang.reflect.Proxy;

public class Exam0110 {

  public static void main(String[] args) {

    MyInterface obj = (MyInterface) Proxy.newProxyInstance(Exam0110.class.getClassLoader(),
        new Class[] {MyInterface.class}, new MyInvocationHandler());

    System.out.println(obj.m1(100, 200));
    System.out.println(obj.m2("홍길동", 27));
  }

}
