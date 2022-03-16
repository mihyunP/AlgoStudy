package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_1260_DFS와BFS {

	
	static int N, M, V;
	static boolean[] visited;
	static ArrayList<Integer>[] adjList;
	
	public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("BOJ_1260_DFS와BFS.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjList = new ArrayList[N + 1];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		visited = new boolean[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}

		for (int i = 0; i < N + 1; i++) {
			Collections.sort(adjList[i]);
		}
		
		dfs(V);
		System.out.println();
		bfs();
		System.out.println();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		q.offer(V);
		visited[V] = true;
		
		while (!q.isEmpty()) {
			int current = q.poll();
			
			System.out.print(current + " ");
			
			for (Integer n : adjList[current]) {
				if (!visited[n]) {
					q.offer(n);
					visited[n] = true;
				}
			}
		}		
	}

	private static void dfs(int current) {
		if (current > N) return;
		visited[current] = true;
		System.out.print(current + " ");
		
		for (Integer n : adjList[current]) {
			if (!visited[n]) {
				dfs(n);
			}
		}
	}

}
