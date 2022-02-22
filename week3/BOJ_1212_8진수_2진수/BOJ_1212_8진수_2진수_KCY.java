package Algo_2022.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			if(i==0 && now <4) {
				if(now<2) { //0,1인 경우 앞의 두자리('00') 잘라주기
					sb.append(binary[now].substring(2));
				}else {// 2,3인 경우 앞의 한 자리 ('0') 잘라주기 
					sb.append(binary[now].substring(1));
				}
			}else {
				sb.append(binary[now]);
			}
		}
		System.out.println(sb.toString());
	}
}
