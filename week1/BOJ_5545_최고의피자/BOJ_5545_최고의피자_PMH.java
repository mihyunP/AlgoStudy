package week1;

import java.util.Arrays;
import java.util.Scanner;

public class 최고의피자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 토핑의 종류의 수 N(1 ≤ N ≤ 100)
		
		int A = sc.nextInt(); // 도우의 가격 A(1 ≤ A, B ≤ 1000) 
		int B = sc.nextInt(); // 토핑의 가격 B(1 ≤ A, B ≤ 1000) 
		
		int C = sc.nextInt(); // 도우의 열량(1 ≤ A, B ≤ 1000) 
		int[]D = new int[N]; // 토핑의 열량
		
		for (int i = 0; i < N; i++) {
			D[i] = sc.nextInt(); // 각 토핑의 열량(1 ≤ Di ≤ 10000) 
		}
		
		Arrays.sort(D);
		
		int price = A; // 최고의 피자 가격
		int cal = C; // 최고의 피자 열량
		int ans = cal/price;
		
		for (int i = 0; i < N; i++) {
			price +=B;
			cal += D[N-1-i];
			ans = Math.max(ans, cal/price);
			
		}
		
		System.out.println(ans);
		
	}

}
