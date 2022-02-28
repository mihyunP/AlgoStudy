package week4_구현;

import java.util.Scanner;

public class BOJ_2503_숫자야구 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 질문 횟수(1<=N<=100)

		int[] num = new int[N];
		int[] strike = new int[N];
		int[] ball = new int[N];

		int total = 0;

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt(); // 민혁이가 질문한 세 자리 수

			strike[i] = sc.nextInt(); // 스트라이크 개수
			ball[i] = sc.nextInt(); // 볼의 개수

		}

		// 세자리 수 완전 탐색
		for (int i = 111; i < 1000; i++) {
			String str_i = Integer.toString(i);

			if (str_i.charAt(0) == str_i.charAt(1) || str_i.charAt(0) == str_i.charAt(2)
					|| str_i.charAt(1) == str_i.charAt(2)) {
				continue;
			} // i의 자리수 중 두자리 이상 같으면 continue

			if (str_i.contains("0")) {
				continue;
			} // i의 자리수 중 0 포함하면 continue

			boolean[] checkFilter = new boolean[N]; // 조건 N개 각각 만족하면 각 방 true/false
			// N가지 조건 모두 만족하는지 확인
			for (int n = 0; n < N; n++) {
				boolean[] isContain = new boolean[3]; // 각 자리수별 포함하는지 ball+strike개수와 동일
				boolean[] isSameLocation = new boolean[3]; // 각 자릿수별 같은 위치인지 strike개수와 동일

				String first = String.valueOf(Integer.toString(num[n]).charAt(0)); // 백의 자리 수
				String second = String.valueOf(Integer.toString(num[n]).charAt(1)); // 십의 자리 수
				String third = String.valueOf(Integer.toString(num[n]).charAt(2)); // 일의 자리 수
				// 문자(char)를 -> 문자열(String)로

				int strikeCnt = 0;
				int ballCnt = 0;

				// 포함하는지
				if (str_i.contains(first)) {
					isContain[0] = true;
				}
				if (str_i.contains(second)) {
					isContain[1] = true;
				}
				if (str_i.contains(third)) {
					isContain[2] = true;
				}

				// 같은 위치인지
				if (String.valueOf(str_i.charAt(0)).equals(first)) {
					isSameLocation[0] = true;
				}
				if (String.valueOf(str_i.charAt(1)).equals(second)) {
					isSameLocation[1] = true;
				}
				if (String.valueOf(str_i.charAt(2)).equals(third)) {
					isSameLocation[2] = true;
				}

				
				
				for (int z = 0; z < 3; z++) {
					if (isContain[z] && isSameLocation[z]) {
						strikeCnt++; // 민혁이가 말한 수 포함, 같은 위치일때 strike개수 증가
					}
					if (isContain[z] && !isSameLocation[z]) {
						ballCnt++; // 민혁이가 말한 수 포함, 다른 위치일때 ball개수 증가
					}
				}

				if (strike[n] == strikeCnt && ball[n] == ballCnt) {
					checkFilter[n] = true;
				}

			} // EndFor
			
			boolean a = true;
			for (int k = 0; k < N; k++) {
				if (!checkFilter[k]) {
					a = false;
				}
			}
			if (a) {
				total++;
//				System.out.println(i);
			}

		} // EndFor
		
		System.out.println(total);
	}

}

