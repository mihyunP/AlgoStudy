package 스터디문제_2022;

import java.util.*;
import java.io.*;

/**
 * 삼각형을 만들 수 있는 경우 중에 둘레가 가장 큰 삼각형 찾기
 */
public class BOJ_1448_삼각형만들기 {

	// 3 <= N <= 1,000,000
	static int N, ans = -1;
	static Integer[] straws;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_1448_삼각형만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		straws = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			straws[i] = Integer.parseInt(st.nextToken());
		}
		
		// 내림차순으로 정렬
		Arrays.sort(straws, Collections.reverseOrder());
		
		
		// 배열을 내림차순으로 정렬한 상태이므로
		// 인덱스 0부터 삼각형을 만들어볼 때
		// 만약 idx0 >= idx1 + idx2 라서 삼각형을 만들 수 없다면 idx0, idx1, idx3 이든 idx0, idx2, idx3이든 idx0을 사용하면 삼각형을 만들 수 없다.
		// 그리고 어차피 idx0 < idx1 + idx2 라면 가장 큰 둘레의 삼각형은 다른 조합을 볼 필요없이 idx0, idx1, idx2로 이루어진 삼각형이 된다.
		// 이를 원리로 삼각형의 가장 긴 변을 idx0부터 idx(N - 3)까지 확인하면서 조사한다.
		for (int i = 0; i < (N - 2); i++) {
			if (straws[i] < (straws[i + 1] + straws[i + 2])) {
				ans = straws[i] + straws[i + 1] + straws[i + 2];
				break;
			}
		}
		
		System.out.println(ans);
	}

}
