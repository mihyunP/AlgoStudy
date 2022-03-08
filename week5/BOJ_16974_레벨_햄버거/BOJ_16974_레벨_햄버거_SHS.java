package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_16974_레벨햄버거 {

	static int N;
	static long X, ans;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_16974_레벨햄버거.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		
		long[] hamburger = calculatePettys(0, 1, 0);
		long petty = hamburger[0];
		long burger = hamburger[1];
		recursive(petty, 1, (petty + burger + 1) / 2, petty + burger);
		System.out.println(ans);
	}

	private static long[] calculatePettys(int level, long petty, long burger) {
		if (level == N) {
			long[] res = {petty, burger};
			return res;
		}
		
		return calculatePettys(level + 1, petty * 2 + 1, burger * 2 + 2);
	}

	private static void recursive(long petty, long first, long mid, long end) {
		if (first > X) {
			return;
		}
		if (end <= X) {
			ans += petty;
			return;
		}
		
		recursive((petty - 1) / 2, first + 1, (first + mid) / 2, mid - 1);
		if (mid <= X) ans++;
		recursive((petty - 1) / 2, mid + 1, (mid + end) / 2, end - 1);
	}

}
