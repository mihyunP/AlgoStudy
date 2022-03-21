package week7_정렬;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11656_접미사배열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next(); // 문자열
		int len = str.length(); // 문자열의 길이
		
		String[] suffix = new String[len];
		for (int i = 1; i <= len; i++) {
			
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j <= i; j++) {
				sb.append(str.charAt(j));
			}
			suffix[i-1] = String.valueOf(sb);
		}
		
		Arrays.sort(suffix);
		
		
	}

}
