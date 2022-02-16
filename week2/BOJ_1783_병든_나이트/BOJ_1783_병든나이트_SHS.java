package 스터디문제_2022;

import java.io.*;
import java.util.*;

public class BOJ_1783_병든나이트 {

	// 첫째 줄에 체스판의 세로 길이 N와 가로 길이 M이 주어진다. 
	// N과 M은 2,000,000,000보다 작거나 같은 자연수이다.
	static int N, M, ans;
	static boolean flag = true;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_1783_병든나이트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if (N < 3 || M < 7) flag = false;
		
		ans = solve(flag);
		System.out.println(ans);
	}

	private static int solve(boolean flag) {
		// 방문한 칸이 5칸 이상인 경우
		if (flag) {
			return M - 2;
		} else {
			// 세로든 가로든 크기가 1인 배열은 시작점만 방문
			if (N == 1 || M == 1) {
				return 1;
			}
			
			// 세로가 2칸은 오른쪽 2칸이동만 가능
			if (N == 2) {
				// 그런 중에 가로 2칸이하면 시작점만 방문
				if (M < 3) return 1;
				else if (M > 6) return 4;
				// 가로가 3칸 이상이면 다음식이 성립
				else return (M + 1) / 2;
			}
			// 세로가 3칸 이상이고 가로가 3칸이면 방문 총 3칸
			if (M == 2) return 2;
			if (M == 3) return 3;
			// 그 이상부터는 어차피 최대 방분칸 수가 4이므로 고정적으로 4
			return 4;

		}
	}

}
