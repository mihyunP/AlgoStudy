package Algo_2022.week02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
	/**
	 * 난이도 : 인접한 두 통나무 간의 높이 차의 최댓값
	 * 구할것 : 통나무들로 만들 수 있는 최소 난이도 
	 * 시간 복잡도 : 10000*10000
	 */
	static int T, N, res;
	static int[] woods;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input/통나무_건너뛰기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
	
		for(int tc =0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			res = Integer.MAX_VALUE;
			woods = new int [N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				woods[i] = Integer.parseInt(st.nextToken());
			}
			
			int mid=0, left=0, right=0,nowLeft=0,nowRight=0;
			Arrays.sort(woods);
			int max = Integer.MIN_VALUE;
			
			mid = woods[N-1];
			left = woods[N-1-2];
			right = woods[N-1-1];
				
			max = Math.max(max, Math.abs(mid - left));	
			max = Math.max(max, Math.abs(mid - right));
			
			for(int i=N-1-2; i-2>=0; i-=2) {
				nowLeft = woods[i-2];
				nowRight = woods[i-1];
				
				max = Math.max(max, Math.abs(left-nowLeft));
				max = Math.max(max, Math.abs(right-nowRight));
				
				left = nowLeft;
				right = nowRight;
			}
			// 짝수일 경우에 -1쪽 : 오른쪽이 남아서 한번 더해준다
			if(N%2==0) {
				max = Math.max(max, Math.abs(woods[0]-nowRight));
			}
			res = Math.min(res, max);
			
			System.out.println(res);
		}
	}

}
	
