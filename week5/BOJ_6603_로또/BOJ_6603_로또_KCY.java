package Algo_2022.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * k개의 집합(조합) 만들기
 * 만든것 가지고 또 6개 선택하기
 * @author tomyb
 *
 */
public class BOJ_6603_로또_KCY {
	static int k;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String str = br.readLine();
			if(str.length()==1) break;
			StringTokenizer st = new StringTokenizer(str, " ");
			k = Integer.parseInt(st.nextToken());
			arr = new int [k];
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// 중복 x 조합
			combination(0,0,new int[6]);
			System.out.println("");
		}
	}
	private static void combination(int idx, int start, int[] sel) {
		if(idx==6) {
			for(int i=0; i<sel.length; i++) {
				System.out.print(sel[i]+" ");
			}System.out.println();
			return;
		}
		for(int i=start; i<arr.length;i++) {
			sel[idx]= arr[i];
			combination(idx+1, i+1, sel);
		}
	}

}
