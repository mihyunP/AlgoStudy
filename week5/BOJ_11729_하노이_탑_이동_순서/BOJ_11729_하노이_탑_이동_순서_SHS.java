package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_11729_하노이탑이동순서 {

	static int N, cnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_11729_하노이탑이동순서.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		cnt = (int) Math.pow(2, N) - 1;
		sb.append(cnt).append("\n");
		
		hanoi(N, 1, 3, 2);
		
		System.out.println(sb);
	}

	/**
	 *	n : 현재 옮겨야하는 블록 수 (쌓인)
	 *	start : 쌓인 블록들을 옮기는 시작점
	 *	to : 쌓인 블록들을 옮기는 최종 도착점
	 *	tmp : 쌓인 블록들을 잠깐 옮겨두는 임시점
	 */
	private static void hanoi(int n, int start, int to, int tmp) {
		if (n == 1) {
			sb.append(start).append(" ").append(to).append("\n"); 
			return;
		}
		
		// ex ) (1 2 3)의 블록들이 쌓여 있으면 (1 2)의 블록들을 임시점에 옮기고
		// 3번 블록을 도착점에 옮기고
		// 임시점에 옮겨놓은 (1 2)블록들을 다시 최종 도착점에 옮긴다.
		hanoi(n - 1, start, tmp, to);
		hanoi(1, start, to, tmp);
		hanoi(n - 1, tmp, to, start);
	}

}
