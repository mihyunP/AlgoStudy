package week2_GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Collections;

public class 삼각형만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 빨대의 개수 (3<=N<=1,000,000)
		Integer [] arr = new Integer [N]; 
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
//		Arrays.sort(arr,Collections.reverseOrder()); // 거꾸로 정렬하기	
		
		int ans = 0;
//		삼각형 조건 : 짧은 두변의 길이 합이 가장 긴변보다 김.	
		for (int i = N-1; i >=2 ; i--) {
			if(arr[i]< arr[i-1]+arr[i-2]) {
				ans = arr[i]+ arr[i-1] + arr[i-2];
				break;
			}
			ans = -1; // 삼각형 못만드는 경우
		}
		
		System.out.println(ans);

	}

}

// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// Integer.parseInt(br.readLine());
// Arrays.sort(arr,Collections.reverseOrder()); // 거꾸로 정렬하기
