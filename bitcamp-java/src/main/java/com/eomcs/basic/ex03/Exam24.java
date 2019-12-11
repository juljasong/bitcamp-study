package com.eomcs.basic.ex03;

public class Exam24 {

  public static void main(String[] args) {
    
    // 5
    // 0000 0000 0000 0000 0000 0000 0000 0101
    System.out.println(5);
    // 23(0001 0111)
    
    // -23
    // (1) sign-magnitude => 1000 0000 0000 0000 0000 0000 0001 0111
    // 23 + (-23) = 0
    // 0000 0000 0000 0000 0000 0000 0001 0111
    // 1000 0000 0000 0000 0000 0000 0001 0111
    //------------------------------------------
    // 1000 0000 0000 0000 0000 0000 0010 1110 = -46

    // (2) 1's complement (1의 보수)
    // 모든 비트를 1이 되는 수로 바꾼다. 0을 1로, 1을 0으로.
    // 0000 0000 0000 0000 0000 0000 0001 0111 (23)
    // 1111 1111 1111 1111 1111 1111 1110 1000 (-23)

    // 0000 0000 0000 0000 0000 0000 0001 0111
    // 1111 1111 1111 1111 1111 1111 1110 1000
    //------------------------------------------
    // 1111 1111 1111 1111 1111 1111 1111 1111
    //+                                      1
    //------------------------------------------
    //1 0000 0000 0000 0000 0000 0000 0000 0000 -> 맨 앞의 1은 메모리 초과로 사라지는 수
    // 항상 음수를 더할 때는 항상 결과에 1을 추가해야 한다

    // (3) 2's complement
    // -> 1의 보수로 저장된 음수 값을 더할 때 마다 계산 결과에 1을 추가하는 번거로움을 없애기 위해 미리 음수를 저장할 때 1을 추가해 두는 방법
    // => 1의 보수 + 1 => 2의 보수
    // 0000 0000 0000 0000 0000 0000 0001 0111
    // 1111 1111 1111 1111 1111 1111 1110 1001
    //------------------------------------------
    //1 0000 0000 0000 0000 0000 0000 0000 0000 
    // 그래서 컴퓨터에서 음수를 메모리에 저장할 때는 양수와 음수를 더할 때 정상적인 값이 나오도록 2의 보수 방법으로 음수를 저장함
    System.out.println(-23); 
  }
}