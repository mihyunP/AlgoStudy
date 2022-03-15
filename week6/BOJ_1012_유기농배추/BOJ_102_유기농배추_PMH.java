package week6_DFSBFS;

import java.util.Scanner;

public class BOJ_1012_유기농배추 {
	static int M, N;
	static int[][] arr;
	static boolean[][] visit;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 0; tc < T; tc++) {
			
			int cnt = 0;
			M = sc.nextInt(); // 배추밭 가로길이
			N = sc.nextInt(); // 배추밭 세로길이
			arr = new int[N][M]; 
			visit = new boolean[N][M];
			
			int K = sc.nextInt(); // 배추 위치의 개수
			
			for (int i = 0; i < K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				arr[r][c] = 1;
			}
			
//			print(arr);
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(arr[r][c]==1 && !visit[r][c]) { // 배추부분
						dfs(r,c); // 재귀 돌리기
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
		
	}

	private static void dfs(int r, int c) {
		// TODO Auto-generated method stub
		visit[r][c]=true; // 방문 체크
		
		int[] dr = {-1,1,0,0}; 
		int[] dc = {0,0,-1,1}; // 상하좌우
		
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=0 && nr<N &&nc>=0 && nc<M) { // 경계선 체크
				if (arr[nr][nc]==1 && !visit[nr][nc]) { // 배추가 있고 방문하지 않은 곳
					dfs(nr,nc); // 재귀
				}
			}
		}
		
	}

	private static void print(int[][] arr) {
		// TODO Auto-generated method stub
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				System.out.print(arr[r][c]+" ");
			}
			System.out.println();
		}
	}

}
