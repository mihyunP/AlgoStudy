package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_11047_동전0 {

	static int N, K, ans;
	static int[] coins;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_11047_동전0.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coins = new int[N];
		int idx = N - 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			coins[i] = Integer.parseInt(st.nextToken());
			
			if (coins[i] > K && idx == (N - 1)) idx = i - 1;
		}
		
		while (K > 0) {
			int div = K / coins[idx];
			ans += div;
			K -= coins[idx] * div;
			idx--;
		}
		
		System.out.println(ans);
	}

}
