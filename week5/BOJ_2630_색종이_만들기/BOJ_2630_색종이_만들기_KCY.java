package Algo_2022.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class BOJ_2630_색종이_만들기_KCY {
	static int N;
	static int[][]arr;
	static HashMap<Integer,Integer> hm;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		hm = new HashMap<>();
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		hm.put(0,0);
		hm.put(1,0);
		checkOnly(0,0,arr.length);
		for (Integer key : hm.keySet()) {
	        System.out.println(hm.get(key)); 
	    }
		
	}
	//r,c에서 길이 몇 만큼 돌아야 한다
	static void checkOnly(int r, int c, int len) {
		boolean flag = false;
		L : for(int i=r; i<r+len; i++) {
			for(int j=c; j<c+len; j++) {
				if(arr[i][j]!= arr[r][c]) {
					flag = true;
					break L;
				}
			}
		}
		// 모두 같은 수면 끝
		if(!flag) {
			hm.put( arr[r][c], hm.get( arr[r][c])+1);
			return;
		}else {
		// 모두 같은 수가 아니라면 자르기(4등분으로 자르기)
			for(int i=r; i<r+len; i+=len/2) {
				for(int j=c; j<c+len; j+=len/2) {
					checkOnly(i, j, len/2);
				}
			}
		}
	}

}
