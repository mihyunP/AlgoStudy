package week3_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 팔진수이진수2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String octal = br.readLine();

		StringBuilder sb = new StringBuilder();

		
		if (octal.charAt(0) == '0') {
			sb.append("0");
		} else if (octal.charAt(0) == '1') {
			sb.append("1");
		} else if (octal.charAt(0) == '2') {
			sb.append("10");
		} else if (octal.charAt(0) == '3') {
			sb.append("11");
		} else if (octal.charAt(0) == '4') {
			sb.append("100");
		} else if (octal.charAt(0) == '5') {
			sb.append("101");
		} else if (octal.charAt(0) == '6') {
			sb.append("110");
		} else if (octal.charAt(0) == '7') {
			sb.append("111");
		}
			
		for (int i = 1; i < octal.length(); i++) {
			if (octal.charAt(i) == '0') {
				sb.append("000");
			} else if (octal.charAt(i) == '1') {
				sb.append("001");
			} else if (octal.charAt(i) == '2') {
				sb.append("010");
			} else if (octal.charAt(i) == '3') {
				sb.append("011");
			} else if (octal.charAt(i) == '4') {
				sb.append("100");
			} else if (octal.charAt(i) == '5') {
				sb.append("101");
			} else if (octal.charAt(i) == '6') {
				sb.append("110");
			} else if (octal.charAt(i) == '7') {
				sb.append("111");
			}
		}
			System.out.println(sb);

	}
}
