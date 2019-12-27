package com.eomcs.oop.ex02.study;

public class GasStation {
  
  static int type;
  
  static int refuel(Car c) {
    if (c.type != type)
      return 0;
    
    int amount = 100 - c.energy;
    c.energy = 100;
    return amount;
  }
  
  static void clean(Car c) {
    c.cleanLevel = 0;
  }

}
