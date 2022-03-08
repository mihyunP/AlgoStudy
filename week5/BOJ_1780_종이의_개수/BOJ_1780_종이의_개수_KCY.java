package Algo_2022.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * 모두 같은수인지 확인
 * 모두 같은 수면 끝
 * map<integer,integer>-1,0,1 갯수 담기
 * 같은 수가 아니라면 자르기
 * @author tomyb
 */
public class BOJ_1780_종이의_개수_KCY {
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
		hm.put(-1,0);
		hm.put(0,0);
		hm.put(1,0);
		checkOnly(0,0,arr.length);
		//Set<Integer> keySet = hm.keySet();
		//System.out.println(keySet.toString());
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
		// 모두 같은 수가 아니라면 자르기(9등분으로 자르기)
			for(int i=r; i<r+len; i+=len/3) {
				for(int j=c; j<c+len; j+=len/3) {
					checkOnly(i, j, len/3);
				}
			}
		}
	}

}
