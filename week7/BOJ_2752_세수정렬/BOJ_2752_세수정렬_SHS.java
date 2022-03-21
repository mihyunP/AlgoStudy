package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_2752_세수정렬 {

	static int[] nums;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_2752_세수정렬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[3];
		
		for (int i = 0; i < 3; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
	}

}
