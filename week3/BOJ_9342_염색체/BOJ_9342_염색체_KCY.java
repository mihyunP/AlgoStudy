package Algo_2022.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9342_염색체_KCY {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			String str = br.readLine();
			// true면 Infected!
			if(check(str)) {
				System.out.println("Infected!");
			}
			// false면 Good
			else {
				System.out.println("Good");
			}
		}
	}

	private static boolean check(String str) {
		int a=0,f=0,c=0,abcdef=0;
		boolean flag = false;
		for(int i=0; i<str.length(); i++) {
			// 그 다음에는 A가 하나 또는 그 이상 있어야 한다
			if(str.charAt(i)=='A') {
				a++;
			}
			// 그 다음에는 F가 하나 또는 그 이상 있어야 한다
			if(str.charAt(i)=='F') {
				f++;
			}
			// 그 다음에는 C가 하나 또는 그 이상 있어야 한다
			if(str.charAt(i)=='C') {
				c++;
				// AAFCCF 처럼 계속 C인 경우면 C다음 {A,B,C,D,E,F}를 체크해 줄 필요가 없어서
				if(i<str.length()-1) {
					if(str.charAt(i+1)!=str.charAt(i)) {
						flag = true;
					}
				}
			}
			// falg가 true일 경우 = C다음이 C와 다르다면
			if(c>0 && flag) {
				// AAFCCT
				// {A, B, C, D, E, F} 중 0개 또는 1개가 있으며
				if(str.charAt(i)=='A'||str.charAt(i)=='B'||str.charAt(i)=='C'||
						str.charAt(i)=='D'||str.charAt(i)=='E'||str.charAt(i)=='F') {
					abcdef++;
				//더 이상의 문자는 없어야 한다.
				}else {
					return false;
				}
			}
			if(abcdef>1) {
				return false;
			}
			if(f>0 && a==0) return false;
			if((c>0 && a==0 )||(c>0 && f==0)) return false;
		}
		// afc가 하나라도 하나 이하면 false
		if(a<1||f<1||c<1) return false;
		// 그게 아니라면 
		
		return true;
	}

}
