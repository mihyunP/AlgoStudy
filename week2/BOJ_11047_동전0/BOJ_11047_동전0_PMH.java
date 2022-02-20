package week2_GreedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class 동전0 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int ans = 0;
		int N = sc.nextInt(); // 동전의 종류
		int K = sc.nextInt(); // 가치의 합
		
		int[] arr = new int[N]; // 각 동전의 가치
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for (int i = N-1; i >= 0; i--) { // 큰 금액의(GREEDY) 동전부터 빼주기
			while (K>=arr[i]) {
				K-=arr[i];
				ans++;
			}
			
			
		}
		
		System.out.println(ans);
		
		
	}
	
}
