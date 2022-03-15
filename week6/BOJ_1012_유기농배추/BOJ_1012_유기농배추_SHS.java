package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_1012_유기농배추 {

	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int T, N, M, K, ans;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_1012_유기농배추.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			ans = 0;
			map = new int[N][M];
			visit = new boolean[N][M];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				map[Y][X] = 1;
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visit[r][c] && map[r][c] == 1) {
//						dfs(r, c);
						bfs(r, c);
						ans++;
					}
				}
			}
			
			System.out.println(ans);
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		visit[r][c] = true;
		q.offer(new Point(r, c));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if (visit[nr][nc] || map[nr][nc] == 0) continue;
				
				visit[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}
		
		
	}

	private static void dfs(int r, int c) {
		visit[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
			if (visit[nr][nc] || map[nr][nc] == 0) continue;
			
			dfs(nr, nc);
		}
	}

}
