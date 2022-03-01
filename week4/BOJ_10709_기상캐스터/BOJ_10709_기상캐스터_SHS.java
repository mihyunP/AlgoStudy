package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_10709_기상캐스터 {

	static int H, W;
	static char[][] input;
	static int[][] ans;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_10709_기상캐스터.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		ans = new int[H][W];
		for (int r = 0; r < H; r++) {
			String str = br.readLine();
			int cnt = 0;
			boolean flag = false;
			for (int c = 0; c < W; c++) {
				if (str.charAt(c) == 'c') {
					ans[r][c] = 0;
					cnt = 0;
					flag = true;
					continue;
				}
				if (flag) ans[r][c] = ++cnt;
				else ans[r][c] = -1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		print(sb);
	}

	private static void print(StringBuilder sb) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				sb.append(ans[r][c]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
