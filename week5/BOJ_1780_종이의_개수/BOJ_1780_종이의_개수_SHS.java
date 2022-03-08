package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_1780_종이의개수 {

	static int N;
	static int[][] arr;
	static int[] ans;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("BOJ_1780_종이의개수.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());		
		arr = new int[N][N];
		ans = new int[3];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(N, 0, 0);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(ans[i]);
		}
	}

	private static void recursive(int size, int r, int c) {
		if (size == 1) {
			ans[arr[r][c] + 1]++;
			return;
		}
		
		int num = check(size, r, c);
		if (num != -2) {
			ans[num + 1]++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				recursive(size / 3, r + (size / 3) * i, c + (size / 3) * j);
			}
		}
	}

	private static int check(int size, int R, int C) {
		int num = arr[R][C];
		for (int r = R; r < R + size; r++) {
			for (int c = C; c < C + size; c++) {
				if (num != arr[r][c]) return -2;
			}
		}
		return num;
	}

}
