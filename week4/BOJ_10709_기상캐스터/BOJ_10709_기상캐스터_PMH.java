package week4_구현;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10709_기상캐스터 {
	static int H, J;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		H = sc.nextInt(); 
		J = sc.nextInt(); 
		
		
		char[][] arr = new char[H][J];
		
		for (int r = 0; r < H; r++) {
			String str = sc.next();
			for (int c = 0; c < J; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		
		int[][]ans = new int[H][J];
		
		for (int i = 0; i < H; i++) {
			Arrays.fill(ans[i], -1);
		}
		
		
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < J; c++) {
				
				// 바로 구름
				if (arr[r][c]=='c') {
					ans[r][c]=0;
				}
				// 왼쪽 방향 구름 탐색
				else {
//					arr[r][c-1]
//					arr[r][c-2]
//					arr[r][c-3] == 'c'
					
					for (int i = 1; i <= c; i++) {
						if(arr[r][c-i]=='c') {
							ans[r][c] = i;
							break;
						}
					}
				}
			}
		}

		print(ans);
		
	}
	private static void print(int[][] ans) {
		// TODO Auto-generated method stub
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < J; c++) {
				System.out.print(ans[r][c]+" ");
			}
			System.out.println();
		}
	}

}
