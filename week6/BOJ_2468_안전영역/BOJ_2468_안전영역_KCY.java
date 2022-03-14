package Algo_2022.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 최댓값 구함
 * 1~최댓값까지 for문
 * 안전영역 갯수 최댓값 구함
 * @author tomyb
 *
 */
public class BOJ_2468_안전영역_KCY {
	static int N,rainMax,ans;
	static int[][]arr;
	static int dr[]	= {-1,1,0,0};
	static int dc[] = {0,0,-1,1}; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		rainMax=1;
		ans = Integer.MIN_VALUE;
		StringTokenizer st = null;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				rainMax = Math.max(rainMax, arr[i][j]);
			}
		}
		solution();
		System.out.println(ans);
		
	}
	private static void solution() {
		// 비가 아예 오지않을 경우도 고려해줘야 한다
		for(int i=0; i<=rainMax; i++) {
			
			boolean[][] v = new boolean[N][N];
			int cnt=0;
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(arr[j][k]>i&&!v[j][k]) {
						cnt++;
						v = bfs(v,j,k,i);
					}
				}
			}
			// 안전영역 갯수 최댓값 구함
			ans = Math.max(ans,cnt);
		}
	}
	private static boolean[][] bfs(boolean[][]v, int r, int c,int depth) {
		Queue<int[]> q = new LinkedList<>();
		v[r][c]=true;
		q.add(new int[] {r,c});
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			for(int d=0; d<4; d++) {
				int nr = current[0]+dr[d];
				int nc = current[1]+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]&&arr[nr][nc]>depth) {
					q.add(new int[] {nr,nc});
					v[nr][nc]=true;
				}
			}
		}
	return v;
	}
	
}
