package com.eomcs.basic.ex06.assignment;

public class Test032 {

	public static void main(String[] args) {

		int width = Console.inputInt();  // 홀수 기준, 밑 변 길이

		if (width % 2 == 0) { // 밑변 길이를 짝수로 받으면 전체적으로 한 칸이 밀려서 출력된다
		  width--;            // spaceSize가 width/2로 나누어 떨어져 전체적으로 빈 칸이 한 칸씩 더 찍히기 때문
		}                     // 하지만  어쨌든 line은 홀수로 찍히는 것만 지키면 되니 전체적인 모양 손상은 없음 

		int spaceSize = width >> 1;  // 맨 첫번째 줄 스페이스는 항상 너비/2-1 => 
									 // width/2에서 나머지를 제외한 값이 spaceSize
		int line = 0; // 0줄 부터 시작

		while (line++ < width) {
			
			if (line % 2 == 0) { // line이 2로 나눠지는 0, 2, 4, ..는 밑의 문장을 실행하지 않음
				continue;	     // line = 한 줄에 별 찍는 수. 별은 홀수로 찍히니 짝수는 패스
			}
			Graphic.drawLine(spaceSize, ' ');
			// int x = 0;
			//<*1>
			// while (x++ < spaceSize) {        => spaceSize(width/2) 만큼 빈 칸을 찍고
			//    System.out.printf(" ");
			//}
			spaceSize--;  // 다음 줄의 스페이스 칸 줄이기, 다음 스페이스 찍는 곳<*1> 이전이면 어디에 둬도 상관 없음.

			Graphic.drawLine(line, '*');
			// int x = 0;
			// while (x++ < line) {
			//    System.out.printf("*");
			//}
			System.out.println(); // 라인 다 찍고 반복문 끝나기 직전에 줄바꿈
		}
	}
}
