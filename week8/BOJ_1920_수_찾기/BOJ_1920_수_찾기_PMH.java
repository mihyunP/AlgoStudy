package week8_이진탐색;

import java.util.Scanner;
import java.util.Arrays;
 
public class Main {
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		
 
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		
		Arrays.sort(A);
		
		int M = sc.nextInt();
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			
			if(binarySearch(A, sc.nextInt()) >= 0) {
				sb.append(1).append('\n');
			}
			else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	public static int binarySearch(int[] A, int key) {
 
		int left = 0;					// 탐색 범위의 왼쪽 끝 인덱스
		int right = A.length - 1;	// 탐색 범위의 오른쪽 끝 인덱스
		
		
		while(left <= right) {
 
			int mid = (left + right) / 2;	// 중간위치 구하기
 
			if(key < A[mid]) {
				right = mid - 1;
			}
			else if(key > A[mid]) {
				left = mid + 1;
			}
			else {
				return mid;
			}
		}
 
		return -1;
 
	}
}
