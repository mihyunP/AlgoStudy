package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_2468_안전영역 {

	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N, maxHeight, ans;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] v;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOj_2468_안전영역.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				maxHeight = maxHeight < map[r][c] ? map[r][c] : maxHeight;
			}
		}
		
		for (int rain = 0; rain <= maxHeight; rain++) {
			
			v = new boolean[N][N];
			int safeArea = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!v[r][c] && map[r][c] > rain) {
						bfs(r, c, rain);
						safeArea++;
					}
				}
			}
			
			ans = ans < safeArea ? safeArea : ans;
		}
		
		System.out.println(ans);
	}

	private static void bfs(int r, int c, int rain) {
		Queue<Point> q = new LinkedList<>();
		v[r][c] = true;
		q.offer(new Point(r, c));
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if (v[nr][nc] || map[nr][nc] <= rain) continue;
				
				v[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}
		
	}

}
