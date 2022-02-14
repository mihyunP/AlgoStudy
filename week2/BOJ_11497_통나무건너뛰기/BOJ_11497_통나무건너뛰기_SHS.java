package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_11497_통나무건너뛰기 {

	static int T, N, ans;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_11497_통나무건너뛰기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			int[] logs = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				logs[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(logs);

			// 아래 for문에서는 idx = 1과 idx = 0의 차이를 계산하지 않아 미리 계산 후 ans에 대입
			int odd1 = logs[1] - logs[0];
			ans = odd1;
			
			// for문에서는 N의 홀수 짝수와 관련없이 인덱스가 홀수인것 끼리, 짝수인것 끼리 인접한 통나무들의 높이 차를 계산 후
			// 그때 그때 가장 큰 값을 ans에 갱신
			for (int i = 1; i < (N / 2); i++) {
				int odd = logs[(2 * i) + 1] - logs[(2 * i) - 1];
				int even = logs[2 * i] - logs[2 * (i - 1)];
				
				int check = 0;
				if (odd < even) check = even;
				else check = odd;
				
				ans = ans < check ? check : ans;
			}	
			
			// 마지막 인덱스인 N - 1 과 N - 2의 차이는 for문에서 고려를 안해줬고
			// 위 for문에서는 N이 홀수면 N - 1과 N - 3도 고려를 안하게 되기 때문에
			// 추가적으로 계산 후 값의 크기에 따라 ans에 반영
			int lastIdx1 = logs[N - 1] - logs[N - 2];
			int lastIdx2 = logs[N - 1] - logs[N - 3];
			
			int check = 0;
			if (lastIdx1 < lastIdx2) check = lastIdx2;
			else check = lastIdx1;
			
			ans = ans < check ? check : ans;
			
			System.out.println(ans);
		}
		
		
	}

}
