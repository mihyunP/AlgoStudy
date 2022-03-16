package week6_DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260_DFS와BFS {
	static int[][]arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 정점의 개수 (1 ≤ N ≤ 1,000)
		int M = sc.nextInt(); // 간선의 개수 (1 ≤ M ≤ 10,000)
		int V = sc.nextInt(); // 탐색을 시작할 정점의 번호
		
		// 인접 행렬 생성 cf. 인접 리스트 생성
		arr = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
			arr[b][a] = 1; // 그래프 양방향 연결
		}
		
		visited = new boolean[N+1];
		dfs(V);
		
		System.out.println();

		visited = new boolean[N+1];
		bfs(V);

	}

	



	// DFS(깊이우선탐색)
	private static void dfs(int V) {
		// TODO Auto-generated method stub
		visited[V] = true;
		System.out.print(V+" ");
		
		if(V==arr.length) {
			return;
		}
		for(int i=1; i<arr.length;i++) {
			
			if(arr[V][i]==1 && !visited[i]) {
				dfs(i);
			}
		}
	}
	
	
	// BFS(너비우선탐색)
	private static void bfs(int V) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(V);
		visited[V] = true; // 방문 체크
		System.out.print(V+" ");
		
		
		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int i = 1; i < arr.length; i++) {
				if (arr[tmp][i]==1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					System.out.print(i+" ");
				}
			}
		}
	}

}
