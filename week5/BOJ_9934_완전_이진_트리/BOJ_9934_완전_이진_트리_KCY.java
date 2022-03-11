package Algo_2022.week05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9934_완전_이진_트리_KCY {
	static int K,size;
	static int[] arr;
	static StringBuffer[] ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		K = Integer.parseInt(br.readLine());
		size = (int) (Math.pow(2, K)-1);
		arr = new int [size];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = new StringBuffer[K];
		for (int i = 0; i < K; i++) {
			ans[i] = new StringBuffer();
		}
		
		tree(0,arr.length-1,0);
		for (int i = 0; i < K; i++) {
			bw.write(ans[i].toString() + "\n");
		}
		bw.flush();
		
	}
	private static void tree(int s, int e, int depth) {

		if(depth ==K) return;
		
		int m = (s+e)/2;
		ans[depth].append(arr[m] + " ");
		tree(s, m - 1, depth + 1);
		tree(m + 1, e, depth + 1);
		
	}

}
