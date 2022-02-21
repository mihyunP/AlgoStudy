package Algo_2022.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10820_문자열_분석 {
	/** 
	 * 문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
	 * EOF : end of file, 데이터 소스로부터 더이상 읽을 데이터가 없음을 나타냄
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		
		while((str = br.readLine()) != null) {
			int[] arr = new int [4]; // 소문자, 대문자, 숫자, 공백의 개수
			for(int i=0; i<str.length(); i++) {
				char now = str.charAt(i);
				if(now == ' ') {
					arr[3]++;
				}else if (now>='a'&&now<='z') {
					arr[0]++;
				}else if(now>='A'&&now<='Z') {
					arr[1]++;
				}else if(now>='0'&&now<='9') {
					arr[2]++;
				}
			}//end for
			for(int i=0; i<arr.length; i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
		}
	}

}
