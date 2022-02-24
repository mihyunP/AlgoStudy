package week3_문자열;

import java.util.Scanner;

public class 염색체 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 개수
		
		for (int tc = 0; tc < T; tc++) {
			
			String str = sc.next(); // 문자열 입력
			
			check(tc, str);
	
		}

	}

	private static void check(int tc, String str) {
		// TODO Auto-generated method stub
		int len = str.length(); // 문자열 길이
		StringBuilder sb = new StringBuilder();
		
		// A F C
		sb.append(str.charAt(0));
		for (int i = 1; i < len; i++) {
			if (str.charAt(i)!=str.charAt(i-1)) {
				sb.append(str.charAt(i));
			}
		}
		String ans = sb.toString();
//		System.out.println(tc+" "+ans);
		
		//AFC, ㅁAFC, AFCㅁ, ㅁAFCㅁ
		if (ans.length()>5) {
			System.out.println("Good");
			return;
		}

		for (int i = 0; i < ans.length(); i++) {
			if (ans.charAt(i)>'F') {
				System.out.println("Good");
				return;
			}
		}

		if (ans.contains("AFC")) {
			System.out.println("Infected!");
		}else {
			System.out.println("Good");
		}
		
	}

}
