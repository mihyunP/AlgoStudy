package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_9342_염색체 {

	static int T;
	static boolean flag;
	static String ans;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_9342_염색체.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < T; tc++) {
			String genome = br.readLine();
			flag = solve(genome);
			
			if (flag) ans = "Infected!";
			else ans = "Good";
			
			System.out.println(ans);
		}
		
	}

	private static boolean solve(String genome) {
		char[] arr = genome.toCharArray();
		
		if (arr[0] > 'F') {
			return false;
		} 

		if (arr[0] == 'A') {
			for (int i = 1; i < genome.length(); i++) {
				if (arr[i] > 'F') return false;
				if (arr[i - 1] == 'A' && arr[i] != 'A' && arr[i] != 'F') {
					return false;
				}
				if (arr[i - 1] == 'F' && arr[i] != 'F' && arr[i] != 'C') {
					return false;
				}
				if (arr[i - 1] == 'C' && i < genome.length() - 1 && arr[i] != 'C') return false;
			}
		} else {
			if (arr[genome.length() - 1] > 'F') return false;
			for (int i = 1; i < genome.length() - 1; i++) {
				if (arr[i] > 'F') return false;
				if (arr[i] == 'A' && arr[i + 1] != 'A' && arr[i + 1] != 'F') return false;
				if (arr[i] == 'F' && arr[i + 1] != 'F' && arr[i + 1] != 'C') return false;
				if (arr[i] == 'C' && i < genome.length() - 1 && arr[i] != 'C') return false;
			}
		}
		
		return true;
	}

}
