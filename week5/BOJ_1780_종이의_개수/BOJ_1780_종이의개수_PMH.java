package week5_재귀;

import java.util.Scanner;

public class BOJ_1780_종이의개수 {

	static int[][] arr;
	static int ans1=0, ans2=0, ans3=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); 
		arr= new int[N][N]; 
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		
		
		paper(0,0,N);
		
		System.out.println(ans1);	// -1
		System.out.println(ans2);	// 0
		System.out.println(ans3);	// 1
	}
	
	private static void paper(int r, int c, int size){
		// TODO Auto-generated method stub
		
		if (check(r, c,size)) {
			if (arr[r][c]==-1) {
				ans1++;
			}else if (arr[r][c]==0) {
				ans2++;
			}else if (arr[r][c]==1) {
				ans3++;
			}
			
			return;
		}
		
		int newSize = size/3;
		
		paper(r, c, newSize); // 상좌
		paper(r, c+newSize, newSize); // 상중
		paper(r, c+newSize*2, newSize); // 상우
		
		paper(r+newSize, c, newSize); // 중좌
		paper(r+newSize, c+newSize, newSize); // 중중
		paper(r+newSize, c+newSize*2, newSize); // 중우
		
		paper(r+newSize*2, c, newSize); // 하좌
		paper(r+newSize*2, c+newSize, newSize); // 하중
		paper(r+newSize*2, c+newSize*2, newSize); // 하우
		
	}

	private static boolean check(int r, int c, int size) {
		// TODO Auto-generated method stub
		int num = arr[r][c];
		
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if (num!=arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
