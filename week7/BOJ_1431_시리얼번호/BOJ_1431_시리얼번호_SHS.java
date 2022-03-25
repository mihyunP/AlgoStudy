package 스터디문제_2022;

import java.util.*;
import java.io.*;

public class BOJ_1431_시리얼번호 {

	static class Serial implements Comparable<Serial>{
		String str;
		int length;
		
		public Serial(String str, int length) {
			this.str = str;
			this.length = length;
		}

		@Override
		public int compareTo(Serial o) {
			if (o.length != this.length) {
				return this.length - o.length;
			} else {
				int A = 0;
				int B = 0;
				
				for (int i = 0; i < o.length; i++) {
					if (o.str.charAt(i) < 58) {
						A += o.str.charAt(i) - '0';
					}
					if (this.str.charAt(i) < 58) {
						B += this.str.charAt(i) - '0';
					}
				}
				if (A != B) return B - A;
				else {
					for (int i = 0; i < o.length; i++) {
						if (o.str.charAt(i) != this.str.charAt(i)) {
							return this.str.charAt(i) - o.str.charAt(i);
						}
					}
				}
			}
			
			return 0;
		}
		
	}
	
	static int N;
	static ArrayList<Serial> serial;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_1431_시리얼번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		
		serial = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			serial.add(new Serial(str, str.length()));
		}
		
		Collections.sort(serial);
		
		for (int i = 0; i < N; i++) {
			sb.append(serial.get(i).str).append("\n");
		}
		
		System.out.println(sb);
	}

}
