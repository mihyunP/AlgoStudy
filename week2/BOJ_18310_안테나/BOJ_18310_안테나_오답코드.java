package week2_GreedyAlgorithm;

import java.util.Arrays;	
import java.util.Scanner;

public class 안테나_오1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 집의 수
		int[] arr = new int[N]; // 집 위치
		
		double sum =0; 
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();			
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		// ans와 가장 가까운 arr[] 원소값 찾기! ==> arr[0]~arr[N] 쭉 돌리면서 차이값 가장 작은 원소값		
		/*
		 * (반례)
		 * 5
		 * 1 7 8 9 10 => 답은 8인테 7 출력함
		 */
		   double ans = Math.round(sum/N);

		   int res = Integer.MAX_VALUE; // 차이값
		   int antena = -1;
		   	
		   for (int i = 0; i < N; i++) {
		   	   if(res > Math.abs(ans-arr[i])) {
		   	   	res = (int)Math.abs(ans-arr[i]);
		   	   	antena = arr[i];
		   	   }			
		   }		   
		   System.out.println(antena);
	}

}

//----------------------------------------------------------------------------------------------------------------------------------
package week2_GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;	
import java.util.Scanner;

public class 안테나_오2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 집의 수
		int[] arr = new int[N]; // 집 위치
		ArrayList<Integer> list = new ArrayList<Integer>(); // 중복 제거한 집 위치
		
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();			
		}
		
		Arrays.sort(arr);
		
		list.add(arr[0]);
		for (int i = 1; i < N; i++) {
			if(arr[i] != arr[i-1]) {
				list.add(arr[i]); 
			}
		}
	
		// arr 배열에 집 위치 전체 넣기, list에 중복 제거한 집 위치 넣어서 list의 각 원소별 '거리 최솟값' 구하고 그때의 list '원소값' 출력하기
		int res = Integer.MAX_VALUE; // 거리 최솟값
		int ans = -1; // 원소값
		
		for (int i = 0; i <list.size() ; i++) {
			int dist = 0; 
			for (int j = 0; j < arr.length; j++) {
				dist += Math.abs(list.get(i)-arr[j]);
			}
			
			if (res > dist) {
				res = dist; // res 갱신
				ans = list.get(i);
			}

		}
		System.out.println(ans);

	}
}
