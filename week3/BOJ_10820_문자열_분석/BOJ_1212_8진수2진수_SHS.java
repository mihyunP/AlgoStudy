package 스터디문제_2022;

import java.io.*;
import java.util.*;

public class BOJ_1212_8진수2진수 {

	static int ten;
	static String s;
	static String[] binaryArr = {"000", "001", "010", "011", "100", "101", "110", "111"};
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BOJ_1212_8진수2진수.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		s = br.readLine();
		int len = s.length();
		if (s.equals("0") && len == 1) sb.append(0);
		else {
			for (int i = 0; i < len; i++) {
				int n = Character.getNumericValue(s.charAt(i));
				
				if (i == 0 && n < 4) {
					switch (n) {
					case 1:
						sb.append("1");
						break;
					case 2:
						sb.append("10");
						break;
					case 3:
						sb.append("11");
						break;

					default:
						break;
					}
				} else sb.append(binaryArr[n]);
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
