import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리에서 모든 리프 노드까지의 합이 홀수가 되면 전체 움짐임 수 홀수이므로 성원이 승
// 루트노드->리프노드 움직임 합 구해서 그 값이 홀수 or 짝수 파악하기
public class Main {

	static int N, answer = 0;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 트리의 정점 개수 N(2 ≤ N ≤ 500,000)
		adjList = new ArrayList[N + 1]; // 1 ~ N
		visited = new boolean[N + 1]; // 1 ~ N

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) { // 간선 수 N-1
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adjList[a].add(b);
			adjList[b].add(a);
		}
		dfs(1, 0);

		System.out.println(answer % 2 == 0 ? "No" : "Yes");

	}

	private static void dfs(int num, int sum) {
		// TODO Auto-generated method stub
		visited[num] = true; // 방문 처리

		for (int i = 0; i < adjList[num].size(); i++) {
			if (!visited[adjList[num].get(i)]) {
				visited[adjList[num].get(i)] = true;
				dfs(adjList[num].get(i), sum + 1);
			}
		}

		if (adjList[num].size() == 1) {
			answer += sum;
		}
	}

}
