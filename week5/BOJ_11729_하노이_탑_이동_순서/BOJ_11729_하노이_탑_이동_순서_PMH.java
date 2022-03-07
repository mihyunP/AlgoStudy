package week5_재귀;

import java.util.Scanner;
	
public class BOJ_11729_하노이탑이동순서 {

	static int K = 0; // 옮긴 횟수
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 원판의 개수 N (1 ≤ N ≤ 20)

		hanoi(N, 1, 2, 3);
		System.out.println(K);

		System.out.println(sb.toString());
	}

	private static void hanoi(int n, int from, int temp, int to) {
		// TODO Auto-generated method stub

		if (n == 0) {
			return;
		}
		// n-1개 원판 이동
		hanoi(n - 1, from, to, temp);
		sb.append(from).append(' ').append(to).append('\n');
//		System.out.println(from + " " + to);
		// n-1개 원판 이동
		hanoi(n - 1, temp, from, to);
		K++;
	}

}
