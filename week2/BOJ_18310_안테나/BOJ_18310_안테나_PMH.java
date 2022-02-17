package week2_GreedyAlgorithm;

import java.util.Arrays;	
import java.util.Scanner;

public class 안테나 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 집의 수
		int[] arr = new int[N]; // 집 위치
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();			
		}
		
		Arrays.sort(arr);

		System.out.println(arr[(N-1)/2]); // 1 4 6 9/ 1 4 7 9/ 1 4 8 9 => 4==6, 4==7, 4==8 
	}
}
