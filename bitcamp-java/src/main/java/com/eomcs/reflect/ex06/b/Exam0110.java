package com.eomcs.reflect.ex06.b;

import java.lang.reflect.Proxy;

public class Exam0110 {

  public static void main(String[] args) {

    MyInterface obj = (MyInterface) Proxy.newProxyInstance(Exam0110.class.getClassLoader(),
        new Class[] {MyInterface.class}, new MyInvocationHandler());

    obj.m1();
    obj.m2(1, 2);
  }

}
