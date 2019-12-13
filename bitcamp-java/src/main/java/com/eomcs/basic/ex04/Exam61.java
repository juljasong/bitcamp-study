package com.eomcs.basic.ex04;

public class Exam61 {
  public static void main(String[] args) {

    // 배열

    int[] score = new int[5];

    // 배열 저장
    score[0] = 100;
    score[1] = 90;
    score[2] = 80;
    score[3] = 70;
    score[4] = 60;

    //score[-1] = 100; runtime error
    //score[5] = 100;  runtime error

    // 배열의 선언과 할당 따로
    int[] arr1 = null;
    arr1 = new int[5];
    arr1[0] = 100;
    arr1[1] = 900;

    System.out.println(arr1[0]);

    // 배열 레퍼런스는 배열 인스턴스의 주소를 담는다.
    int[] arr2; //arr1에 저장된 배열 인스턴스의 주소를 담는다
    arr2 = arr1;

    System.out.println(arr1[0]); // 100
    arr2[0] = 300;
    System.out.println(arr1[0]); // 300

    int[] arr3 = new int[3];
    arr3[0] = 30;

    arr2 = arr3;
    System.out.println(arr2[0]);

    arr1 = arr2;
    System.out.println(arr1[0]); 
    
    // arr1에 저장되었던 기존 배열 인스턴스에 접근하는 방법은............................ 없다.
    // 주소를 잃어버려 접근할 수 없는 메모리를 "가비지Garbage"라고 함
    // JVM 실행 중 메모리가 부족해지면 "가비지 컬렉터"에 의해 메모리에서 지워진다.
    // JVM을 종료하면 JVM이 사용하던 모든 메모리는 OS에 반납되어 가비지 또한 반납될 것이다.
    // 가비지 동작 !) 메모리 부족할 때 2) CPU가 한가할 때

    // 전산학에서는 garbage를 "dangling object"라고 한다

    int[] arr5 = new int[] {1,2,3};
    // int[] arr6 = new int[3] {1,2,3}; 실행오류

    // 배열 선언과 동시에 인스턴스를 초기화시킬 때
    int[] arr7 = {1,2,3};
    //레퍼런스 먼저 생성하고 값을 초기화시킬 때는 new int[] 생략 X
    int[] arr8;
    arr8 = new int[] {1,2,3};

  }
}