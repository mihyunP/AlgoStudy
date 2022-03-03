package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_1371_가장많은글자 {

	static int[] alpha;
	static int most;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_1371_가장많은글자.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		alpha = new int[26];
		
		while ((input = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(input, " ");
			String word = "";
			while (st.hasMoreTokens()) {
				word = st.nextToken();
				spellCheck(word);				
			}
			
		}

		
		for (int i = 0; i < 26; i++) {
			most = most < alpha[i] ? alpha[i] : most;
		}

		for (int i = 0; i < 26; i++) {
			if (most == alpha[i]) {
				System.out.print((char)(i + 97));
			}
		}
		
	}

	private static void spellCheck(String word) {
		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';
			alpha[idx]++;
		}
	}

}
