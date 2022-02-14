package Algo_2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_최고의_피자 {
	/**
	 * 첫째 줄에 토핑의 종류의 수 N(1 ≤ N ≤ 100)이 주어진다. 
	 * 둘째 줄에는 도우의 가격 A와 토핑의 가격 B가 주어진다. (1 ≤ A, B ≤ 1000) 
	 * 셋째 줄에는 도우의 열량 C가 주어진다. (1 ≤ C ≤ 10000) 
	 * 다음 줄부터 N개 줄에는 각 토핑의 열량 Di가 한 줄에 하나씩 주어진다. (1 ≤ Di ≤ 10000)
	 */
	static int N, A, B, C;
	static int[] topings;
	static long res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		res = 0;
		N = Integer.parseInt(br.readLine());
		topings = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			topings[i] = Integer.parseInt(br.readLine());
		}
		// 열량 오름차순 정렬
		Arrays.sort(topings);
		int pizzaPrice = A;
		int totalCal = C;
		// 피자 1원 당 열량 = 칼로리/피자가격
		res = C/A;
		// 오름차순정렬, 끝에서부터 카운트
		for(int i= N-1; i>=0; i--) {
			pizzaPrice += B;
			totalCal += topings[i];
			res = Math.max(res, totalCal/pizzaPrice);
		}
		System.out.println(res);
	}

	

}
