// 비트 이동 연산자 : >>, >>>, << 
package com.eomcs.basic.ex05;

public class Exam04_11 {
    public static void main(String[] args) {
        System.out.println(3 << 1);
        // 00000000 00000000 00000000 00000011
        // 00000000 00000000 00000000 00000110
        // 00000000 00000000 00000000 00001100
        
        // int 값에 대한 비트 이동은 0 ~ 31까지
        System.out.println(3 << 33); // 6
        // long 값에 대한 비트 이동은 0 ~ 63까지
        System.out.println(3 << 65); // 6
        System.out.println(3 << 97); // 6
        // 비트 이동 유효 범위를 벗어나면, int 하위 5비트, long 하위 6비트만 유효
    }
}

// 왼쪽 이동
// - 1비트 이동은 곱하기 2 한 것과 같은 효과를 준다.
