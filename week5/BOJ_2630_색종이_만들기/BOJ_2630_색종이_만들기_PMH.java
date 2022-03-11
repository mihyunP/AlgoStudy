package week5_재귀;

import java.util.Scanner;

public class BOJ_2630_색종이만들기 {
	static int white = 0;
	static int blue = 0;
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 한변의 길이
		arr = new int[N][N]; 
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = sc.nextInt();  // 하얀색:0 , 파란색:1
			}
		}
		
		coloredPaper(0,0,N);
		System.out.println(white);
		System.out.println(blue);
		
	}
	private static void coloredPaper(int r, int c, int n) {
		// TODO Auto-generated method stub
		
		if (isSameColor(r,c,n)) {
			if (arr[r][c]==0) {
				white++;
			}else if (arr[r][c]==1) {
				blue++;
			}
			
			return;
		}
		
		int newN = n/2;
		
		coloredPaper(r, c, newN); // 상좌
		coloredPaper(r, c+newN, newN); // 상우
		coloredPaper(r+newN, c, newN); // 하좌
		coloredPaper(r+newN, c+newN, newN); // 하우

		
	}
	private static boolean isSameColor(int r, int c, int n) {
		// TODO Auto-generated method stub
		int num = arr[r][c];
		
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if (num!=arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
