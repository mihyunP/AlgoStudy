package 스터디문제_2022;

import java.util.*;
import java.io.*;

/**
 * ASCII
 * 공백 : 32
 * A ~ Z : 65 ~ 90
 * a ~ z : 97 ~ 122
 * 0 ~ 9 : 48 ~ 57
 */
public class BOJ_10820_문자열분석 {

	// spaces : 공백, c : 소문자, C : 대문자, nums : 숫자
	static int spaces, c, C, nums;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_10820_문자열분석.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			String str = br.readLine();
			if (str == null) break;
			
			spaces = c = C = nums = 0;
			for (int i = 0; i < str.length(); i++) {
				char letter = str.charAt(i);
				
				if (letter == ' ') spaces++;
				if (letter >= 'A' && letter <= 'Z') C++;
				if (letter >= 'a' && letter <= 'z') c++;
				if (letter >= '0' && letter <= '9') nums++;
			}
			
			sb.append(c).append(" ").append(C).append(" ")
			.append(nums).append(" ").append(spaces).append("\n");
		}
		
		System.out.println(sb);
	}

}
