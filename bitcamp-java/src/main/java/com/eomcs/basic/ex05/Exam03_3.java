// 논리 연산자 : && vs &
package com.eomcs.basic.ex05;

public class Exam03_3 {
    public static void main(String[] args) {
        boolean a = false;
        boolean b = false;
        boolean r = a && (b = true); 
        // && 연산자의 오른쪽의 실행하기 전에 결과를 알 수 있으면 오른쪽을 실행하지 않는다. 
        // (b = true) 실행 X
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);

        a = false;
        b = false;
        r = a & (b = true);
        // r = false & (b = true : true)
        // & 연산자의 경우 왼쪽 값으로 결과를 예측할 수 있다해도 결과에 상관없이 & 오른쪽 문장을 무조건 실행함
        System.out.printf("a=%b, b=%b, r=%b\n", a, b, r);
    }
}
// &&, ||
// - 앞의 피연산자의 값으로 결과를 알 수 있다면 뒤의 명령은 실행하지 않는다.
// 
// &, |
// - 앞의 피연산자로 결과를 알 수 있을 지라도, 
//   뒤에 놓은 명령까지 모두 실행한다.