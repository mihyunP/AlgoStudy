package Algo_2022.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2503_숫자_야구_KCY {
	static int N, res;
	static boolean arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		arr = new boolean[999]; // 123~987 까지만 쓸 것
		Arrays.fill(arr, true);
		res = 0;
		// 초기화
		for (int i = 123; i <= 987; i++) {
			// 중복숫자 제거
			String now = Integer.toString(i);
			if (now.charAt(0) == now.charAt(1) || now.charAt(0) == now.charAt(2) || now.charAt(1) == now.charAt(2)) {
				arr[i] = false;
			}
			if (now.charAt(0) == '0' || now.charAt(1) == '0' || now.charAt(2) == '0') {
				arr[i] = false;
			}
		}
		// 답 체크
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			check(st.nextToken(), st.nextToken(), st.nextToken());
		}
		// 체크배열 true인 값만 세줌
		for (int i = 123; i <= 987; i++)
		{
			if (arr[i])
				res++;
		}
		System.out.println(res);
	}

	private static void check(String num, String strike, String ball) {
		for (int i = 123; i <= 987; i++) {
			if (arr[i]) {
				String now = Integer.toString(i);
				int strikeCnt = 0, ballCnt = 0;
				for (int j = 0; j < 3; j++) {
					for (int t = 0; t < 3; t++) {
						// strike 체크 
						if (num.charAt(j) == now.charAt(t) && j == t) {
							strikeCnt++;
						}
						// ball 체크
						if (num.charAt(j) == now.charAt(t) && j != t) {
							ballCnt++;
						}
					}
				} // end check
				// 입력받은 strike, ball 갯수와 다르다면 가능하지 않음-> 체크배열 false
				if (Integer.parseInt(strike) != strikeCnt || Integer.parseInt(ball) != ballCnt) {
					arr[i] = false;
				}
			}
		}

	}

}
