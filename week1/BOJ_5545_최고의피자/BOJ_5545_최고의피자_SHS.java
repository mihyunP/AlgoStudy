package 스터디문제_2022;

import java.util.*;
import java.io.*;

/**
 * 입력
 * 첫째 줄에 토핑의 종류의 수 N(1 ≤ N ≤ 100)이 주어진다. 
 * 둘째 줄에는 도우의 가격 A와 토핑의 가격 B가 주어진다. (1 ≤ A, B ≤ 1000) 
 * 셋째 줄에는 도우의 열량 C가 주어진다. (1 ≤ C ≤ 10000) 
 * 다음 줄부터 N개 줄에는 각 토핑의 열량 Di가 한 줄에 하나씩 주어진다. (1 ≤ Di ≤ 10000)
 * 
 * 출력
 * 첫째 줄에 최고의 피자의 1원 당 열량을 출력한다. 소수점 이하는 버리고 정수 값으로 출력한다.
 */
public class BOJ_5545_최고의피자 {

	static int N, A, B, C, ans;
	static double rate;
	static int[] D;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_5545_최고의피자.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		
		D = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		// 토핑의 가격은 모두 같으므로 열량이 높은 토핑부터 체크하면 됨
		Arrays.sort(D);
		
		solve();
		
		// 정수부분만 추려서 출력
		ans = (int) rate;
		System.out.println(ans);
		
//		print(D);
	}

	private static void solve() {
		// rate : 피자의 1원당 열량
		// 처음엔 도우의 가격당 열량으로 시작
		rate = C / A;
		// sumCal : 피자의 총 칼로리 - 처음엔 도우의 칼로리로 시작
		// sumPrice : 피자의 총 가격 - 처음엔 도우의 가격으로 시작
		// checkCal : 도우의 1원당 칼로리를 계산 - 현재 선택한 피자의 1원당 열량보다 낮으면 이후 토핑들은 선택할 필요없음 (시간 단축)
		double sumCal = C;
		double sumPrice = A;
		double checkCal = 0;
		// 오름차순 정렬된 배열이므로 역순으로 탐색
		for (int i = (N - 1); i >= 0; i--) {
			// 각 토핑의 가격당 열량 체크
			checkCal = D[i] / B;
			// 토핑의 효율이 더 이상 선택안하고 안나오면 종료
			if (rate > checkCal) break;
			
			// 토핑의 칼로리와 가격을 더한다.
			sumCal += D[i];
			sumPrice += B;
			
			// 효율을 계산해 토핑을 올릴지 말지 결정
			rate = rate < (sumCal / sumPrice) ? (sumCal / sumPrice) : rate;
		}
		
	}

	private static void print(int[] d) {
		for (int i = 0; i < N; i++) {
			System.out.println(d[i]);
		}
	}

}
