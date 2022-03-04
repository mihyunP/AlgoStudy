package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_10994_별찍기19 {

	static int N, len;
	static char[][] stars;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_10994_별찍기19.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		len = 4 * (N - 1) + 1;
		stars = new char[len][len];
		for (int r = 0; r < len; r++) {
			Arrays.fill(stars[r], ' ');
		}
		shootingStar(0);
		
		print(sb);
	}

	private static void print(StringBuilder sb) {
		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				sb.append(stars[r][c]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static void shootingStar(int idx) {
		if (idx == N) return;
		
		fillStar(idx);
		shootingStar(idx + 1);
	}

	private static void fillStar(int idx) {
		int upIdx = idx * 2;
		int downIdx = (len - 1) - (idx * 2);
		int leftIdx = idx * 2;
		int rightIdx = (len - 1) - (idx * 2);
		
		for (int i = leftIdx; i <= rightIdx; i++) {
			stars[upIdx][i] = '*';
		}
		for (int i = leftIdx; i <= rightIdx; i++) {
			stars[downIdx][i] = '*';
		}
		for (int i = upIdx; i <= downIdx; i++) {
			stars[i][leftIdx] = '*';
		}
		for (int i = upIdx; i <= downIdx; i++) {
			stars[i][rightIdx] = '*';
		}
	}

}
