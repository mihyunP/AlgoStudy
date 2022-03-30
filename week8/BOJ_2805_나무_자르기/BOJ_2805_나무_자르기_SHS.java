package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_2805_나무자르기 {

	static int N, M, H;
	static int[] trees;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_2805_나무자르기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(trees);

		int start = 1;
		int end = trees[N - 1];
		int mid = 0;
		
		while (start <= end) {
			mid = (start + end) / 2;
			long total = calculate(mid);
			
			if (total < M) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			
		}
		
		H = end;
		
		System.out.println(H);
	}

	private static long calculate(int height) {
		long res = 0;
		for (int i = 0; i < N; i++) {
			if (trees[i] > height) {
				res += trees[i] - height;
			}
		}
		
		return res;
	}

}
