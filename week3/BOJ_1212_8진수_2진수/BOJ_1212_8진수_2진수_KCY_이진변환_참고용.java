package Algo_2022.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 시간초과 코드
 * 그치만 ,, 테케는 다 맞는다
 * 이진변환 참고용
 * @author tomyb
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 첫째 줄에 주어진 수를 2진수로 변환하여 출력한다. 수가 0인 경우를 제외하고는 반드시 1로 시작해야 한다
		// 314 3->011 1->001 4->100 11001100
		String[]binary = {"000","001","010","011","100","101","110","111"};
		String str = br.readLine();
		StringBuilder sb = new StringBuilder(); 
		for(int i=0; i<str.length(); i++) {
			int now = str.charAt(i)-'0';
			String binaryString = String.format("%3s", Integer.toBinaryString(now)).replace(" ", "0");
			System.out.println(binaryString);
			sb.append(binaryString);
		}
		String res = sb.toString();
		System.out.println(res);
		if(str.equals("0")) {
			System.out.println("0");
		}else {
		int idx =0;
		for(int i=0; i<res.length(); i++) {
			if(res.charAt(i)=='0') {
				idx =i;
			}else {
				break;
			}
		}
		System.out.println(res.substring(idx+1, res.length()));
		}
	}
}
