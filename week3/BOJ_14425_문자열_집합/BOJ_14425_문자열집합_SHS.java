package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_14425_문자열집합 {

	static int N, M, ans;
	static String[] S;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_14425_문자열집합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		S = new String[N];
		for (int i = 0; i < N; i++) {
			S[i] = br.readLine();
		}
		
		for (int i = 0; i < M; i++) {
			if(check(br.readLine())) {
				ans++;
			}
		}

		
		System.out.println(ans);
	}

	private static boolean check(String str) {
		for (int i = 0; i < S.length; i++) {
			if (S[i].equals(str)) {
				return true;
			}
		}
		
		return false;
	}

}
