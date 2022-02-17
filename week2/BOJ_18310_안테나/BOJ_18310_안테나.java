package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_18310_안테나 {

	static int N, ans;
	static double sum;
	static int[] homes;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_18310_안테나.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		homes = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			homes[i] = Integer.parseInt(st.nextToken());
			sum += homes[i];
		}
		
		Arrays.sort(homes);		
		
		ans = homes[(N - 1) / 2];
		System.out.println(ans);
	}

}
