package week4_구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10994_별찍기19 {

	static char[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt(); // 입력 받은 숫자
		arr = new char[4*num-3][4*num-3];
		
		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], ' ');
		} // 배열을 공백으로 채우기
		
		star(0,num); // 사작 좌표 값(+2씩 하기), 별개수는 4*num-3
		print(arr);

	}

	private static void print(char[][] arr) {
		// TODO Auto-generated method stub
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length; c++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
	}

	private static void star(int i, int num) {
		// TODO Auto-generated method stub
		if (num==0) {
			return;
		}
		
		for (int r = 0; r < 4*num-3; r++) {
			for (int c = 0; c < 4*num-3; c++) {
				if (r == 0 || r == 4*num-4) { // 첫행과 마지막행
					arr[i+r][i+c]='*'; // 다찍기
				}else {
					if (c == 0 || c== 4*num-4) { // 나머지 행
						arr[i+r][i+c] = '*'; // 첫열과 마지막열만 찍기
					}
				}
			}
		}
		
		star(i+2,num-1);
	}

}
