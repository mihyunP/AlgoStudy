package week9_DP;

import java.util.Scanner;

public class BOJ_2839_설탕배달 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 설탕 총 무게
		int ans = -1; 
		int cnt = 0; // 배달 봉지 수
		
		
		
		while (N%5 != 0) {
			N-=3;
			cnt++;
		} 
		
		if (N>=0) {
			cnt += N/5;
			ans = cnt;
		}
		
		System.out.println(ans);
	}
}
