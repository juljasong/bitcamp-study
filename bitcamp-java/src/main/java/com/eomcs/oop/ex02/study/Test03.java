package com.eomcs.oop.ex02.study;


public class Test03 {

  public static void main(String[] args) {
 
    Car c1 = new Car();
    Car c2 = new Car();
    
    c1.name = "봉봉";
    c1.type = Car.OIL;
    c1.color = "red";
    c1.speed = 100;
    c1.energy = 20;
    c1.power = 200;
    
    c2.name = "붕붕";
    c2.type = Car.GAS;
    c2.color = "blue";
    c2.speed = 100;
    c2.energy = 30;
    c2.power = 300;
    
    System.out.printf("c1의 잔류량: %d\n", c1.energy);
    System.out.printf("c2의 잔류량: %d\n", c2.energy);
    
    GasStation s1 = new GasStation();
    s1.type = Car.OIL;
    
    GasStation.type = Car.OIL;
    GasStation.refuel(c1);
    GasStation.refuel(c2);
    GasStation s2 = new GasStation();
    s2.type = Car.GAS;
    
    GasStation.clean(c1);
    
    System.out.printf("c1의 잔류량: %d\n", c1.energy);
    System.out.printf("c2의 잔류량: %d\n", c2.energy);
    
    System.out.printf("c1의 청소: %d\n", c1.cleanLevel);
    
    
  }
  
}
