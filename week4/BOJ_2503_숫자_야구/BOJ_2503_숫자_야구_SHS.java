package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_2503_숫자야구 {

	// N : 질문 수		total : 스트라이크와 볼의 총 합	ans : 최종 답
	static int N, total, ans;
	// B[10] : 질문에서 1~9까지의 숫자를 각각 몇 번 물어봤는지 저장
	static int[] B, strikes, balls;
	static int[][] questions;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_2503_숫자야구.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		B = new int[10];
		questions = new int[N][3];
		strikes = new int[N];
		balls = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int question = Integer.parseInt(st.nextToken());
			strikes[i] = Integer.parseInt(st.nextToken());
			balls[i] = Integer.parseInt(st.nextToken());
			
			for (int j = 2; j >= 0; j--) {
				questions[i][j] = question % 10;
				question /= 10;
				B[questions[i][j]]++;
			}
			
			
			total += strikes[i] + balls[i];
		}
//		print(questions);
		recursive(0, new int[3], new boolean[10]);
		
		System.out.println(ans);
	}


	private static void recursive(int idx, int[] sel, boolean[] v) {
		if (idx == 3) {
			if (B[sel[0]] + B[sel[1]] + B[sel[2]] == total) {
				if (check(sel)) {
					ans++;
				}
			}
			return;
		}
		
		for (int i = 1; i < 10; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[idx] = i;
				recursive(idx + 1, sel, v);
				v[i] = false;
			}
		}
		
		
	}

	private static boolean check(int[] sel) {
		for (int i = 0; i < N; i++) {
			int key = strikes[i] * 10 + balls[i];
			
			int strike = 0;
			int ball = 0;
			switch (key) {
			case 0:
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (questions[i][r] == sel[c]) return false;
					}
				}
				break;
			case 1:
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (questions[i][r] == sel[c]) {
							if (r == c) return false;
							ball++;
						}
						if (ball > 1) return false;
					}
				}
				break;
			case 2:
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (ball > 2) return false;
						if (questions[i][r] == sel[c]) {
							if (r == c) return false;
							ball++;
						}
					}
				}
				break;
			case 3:
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (questions[i][r] == sel[c]) {
							if (r == c) return false;
						}
					}
				}
				break;
			case 10:
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (questions[i][r] == sel[c]) {
							if (r != c) return false;
							strike++;
						}
						if (strike > 1) return false;
					}
				}
				break;
			case 11:
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (questions[i][r] == sel[c]) {
							if (r == c) strike++;
							else ball++;
						}
						if (strike > 1) return false;
						if (ball > 1) return false;
					}
				}
				break;
			case 12:
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (questions[i][r] == sel[c]) {
							if (r == c) strike++;
							else ball++;
						}
						if (strike > 1) return false;
						if (ball > 2) return false;
					}
				}
				break;
			case 20:
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (questions[i][r] == sel[c]) {
							if (r != c) return false;
							strike++;
						}
						if (strike > 2) return false;
					}
				}
				break;
			case 21:
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {
						if (questions[i][r] == sel[c]) {
							if (r == c) strike++;
							else ball++;
						}
						if (strike > 2) return false;
						if (ball > 1) return false;
					}
				}
				break;
			case 30:
				for (int r = 0; r < 3; r++) {
					if (questions[i][r] == sel[r]) {
						strike++;
					}
				}
				if (strike != 3) return false;
				break;
			default:
				break;
			}
		}
		
		return true;
	}

}
