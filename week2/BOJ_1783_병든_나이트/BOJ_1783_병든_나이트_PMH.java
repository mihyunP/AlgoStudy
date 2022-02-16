package week2_GreedyAlgorithm;

import java.util.Scanner;

public class 병든나이트 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 체스판의 세로 길이 N
		int M = sc.nextInt(); // 체스판의 가로 길이 M(N과 M은 2,000,000,000보다 작거나 같은 자연수)
		
		int ans=0;
		
		if(N==1) {
			ans = 1;
		}else if (N==2) {
			ans = Math.min(4, (M+1)/2); // 2번, 3번 움직임만 가능함(높이 제한)
		}else if (M<7) {
			ans = Math.min(4, M); // 4번 미만 움직임만 가능함(너비 제한)
		}else {
			ans = M-2; // 위오오, 아오오 1번씩은 써야해서
		}
		System.out.println(ans); 

    
  }
}
