package Algo_2022.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17609_회문_KCY {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			
			String str = br.readLine();
			// 짝수일때
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			if (str.equals(sb.reverse().toString())) {
				System.out.println(0);
			}else {
				// 유사회문인지 확인
				// if 유사회문이면 1
				if (check(str)) {
					System.out.println(1);
					// else 유사회문 아니면 2
				} else {
					System.out.println(2);
				}
			}
		}
	}

	private static boolean check(String str) {
		// start, end 움직인 갯수 >1 이면 return false
		// start, end 움직인 갯수 <=1 이면 return true
		int start=0,end=str.length()-1,cnt1=0;
		// 앞에를 땡기는거
		for(int i=start,j=end ;i<=j; i++,j--) {
			if(str.charAt(i)==str.charAt(j)) {
				
			}else {
//				두개가 다르다면
				j++;
				cnt1++;
			}
		}
		
		start=0;end=str.length()-1;
		int cnt2=0;
		// 뒤에를 땡기는거
		for(int i=start,j=end;i<=j;i++,j--) {
		
			if(str.charAt(i)==str.charAt(j)) {
				
			}else {
//				두개가 다르다면
				i--;
				cnt2++;
			}
		}
		// 하나라도 옮긴 횟수가 1일경우 return true
		if(cnt2==1) return true;
		if(cnt1==1) return true;
		// 아니면 다 유사회문이 아님
		return false;
	}

}
