package Algo_2022.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3 {
	static int N, M;
	static boolean arr[][];
	static int dr[] = { -2, -1, 1, 2 };
	static int dc[] = { 1, 2, 2, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int res = 0;
		if(N==1) {
			res = 1;
			// 위로 아무리 가도 3
		}else if(N==2) {
			res = Math.min(4, (M+1)/2);
			// 옆으로 아무리 가도 6
		}else if(M<7) {
			res = Math.min(4, M);
		}else {
			res = M-2;
		}
		System.out.println(res);
	}

	
}
