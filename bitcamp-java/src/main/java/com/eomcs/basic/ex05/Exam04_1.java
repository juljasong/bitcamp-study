// 비트 이동 연산자 : >>, >>>, << 
package com.eomcs.basic.ex05;

public class Exam04_1 {
    public static void main(String[] args) {
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
        // 왼쪽으로 이동 후, 오른 쪽 빈자리 : 0으로 채우고 왼쪽 경계를 넘어간 비트는 자른다.

        i = 0b0000_1011; // 11
        System.out.println(i << 1); // 22 => 0001_0110
        System.out.println(i << 2); // 44 => 0010_1100
        System.out.println(i << 3); // 88 => 0101_1000
    }
}

// 왼쪽 이동
// - 1비트 이동은 곱하기 2 한 것과 같은 효과를 준다.
