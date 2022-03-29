package week8_이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10815_숫자카드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // (1 ≤ N ≤ 500,000)
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt(); 
		}
		
		Arrays.sort(num);
		int M = sc.nextInt(); // (1 ≤ M ≤ 500,000)
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			sb.append(BinarySearch(num, sc.nextInt())).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static int BinarySearch(int[] num, int key) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = num.length-1;
		
		while (left<=right) {
			int mid = (left + right)/2;
			
			if (key<num[mid]) {
				right = mid-1;
			}else if (key>num[mid]) {
				left = mid+1;
			}else {
				return 1;
			}
		}
		return 0;
	}

}
