package week6_DFSBFS;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visit; // 방문 체크
	static int result =1; // 안전지역 개수 최대값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 행,열개수
		map = new int[N][N];
		int max=Integer.MIN_VALUE;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				map[r][c] = sc.nextInt(); // 높이 정보 저장
				max= Math.max(max, map[r][c]);
			}
		}

		for (int i = 1; i <= max; i++) { // 높이는 1이상 100(->max) 이하의 정수
			// 높이별로 새로 세팅 되어야 할 것들 :
			visit = new boolean[N][N];
			int cnt=0; // 안전지역 개수
			
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]>i &&!visit[r][c]) { // 안잠기고, 안간 부분
						dfs(r,c,i); // 재귀 돌리기
						cnt++;
					}
				}
			}
			result= Math.max(result, cnt); // 최대값 갱신
		} // End For : 높이 별 안전 영역의 개수 구하기

		System.out.println(result); // 안전영역 최대 개수 출력
	}

	private static void dfs(int r, int c, int height) {

		visit[r][c]=true; // 방문 체크
		
		int[] dr = {-1,1,0,0}; 
		int[] dc = {0,0,-1,1}; // 상하좌우
		
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(nr>=0 && nr<N &&nc>=0 && nc<N) { // 경계선 체크
				if (map[nr][nc]>height && !visit[nr][nc]) { // 물에 안잠기고 방문하지 않은 곳
					dfs(nr,nc,height); // 재귀
				}
			}
		}
	} 
}
