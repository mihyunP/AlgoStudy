package Algo_2022.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047_동전0_KCY {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int count = 0;
		// 동전의 최소 갯수니까 내림차순으로 탐색
		for(int i =N-1; i>=0; i--) {
			// 만약 총 가격보다 동전의 가격이 크다면 패스
			if(arr[i]>K) continue;
			
			// 갯수 += 가격/현재동전가격 
			// 가격 = 가격 - 동전갯수 * 현재동전가격
			count += K/arr[i];
			K = K- (K/arr[i]) * arr[i];
			
			if(K<=0) break;
		}
		System.out.println(count);
		
	}

}
