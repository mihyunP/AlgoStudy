package week2_GreedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class 통나무건너뛰기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스
		
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt(); // 통나무의 개수
			int[] L = new int[N]; // 각 통나무의 높이
			
			for (int i = 0; i < N; i++) {
				L[i] = sc.nextInt();
			}
			
			
			Arrays.sort(L);
			int [] I = new int[N];
			

			
			if (N%2 != 0) {
				I[N/2]=L[N-1];
				for (int j = 1; j <= N/2; j++) {
					I[N/2-j] = L[N-2*j];
					I[N/2+j] = L[N-1-2*j];
				}
        				
			}else {
				I[N/2]=L[N-1];
				for (int j = 1; j < N/2; j++) {
					I[N/2-j] = L[N-2*j];
					I[N/2+j] = L[N-1-2*j];
				}
				I[0] = L[0];
			}
			
//			System.out.println(Arrays.toString(I));
			
			
			int res = Math.abs(I[N-1]-I[0]);
			
			for (int i = 1; i < N; i++) {
				int tmp = Math.abs(I[i]-I[i-1]);
				
				res = Math.max(res, tmp);
			}

			
			System.out.println(res);
		}

	}

}
