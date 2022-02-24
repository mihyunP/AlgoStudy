package week3_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 문자열집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
//		Scanner sc = new Scanner(System.in); // scanner 시간초과!!!
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 문자열의 개수 (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)
		int M = Integer.parseInt(st.nextToken()); // 문자열의 개수 (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)
		
		String[] arrN = new String[N]; // 집합 S에 포함되어 있는 문자열
		String[] arrM = new String[M]; // 검사해야 하는 문자열
		
		for (int i = 0; i < arrN.length; i++) {
			arrN[i] = br.readLine();
		}
		
		for (int i = 0; i < arrM.length; i++) {
			arrM[i] = br.readLine();
		}
		
		int cnt = 0;
		
		for (int i = 0; i < arrM.length; i++) {
			for (int j = 0; j < arrN.length; j++) {
				if (arrM[i].equals(arrN[j])) {
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
	}

}

// Scanner -> BufferedReader & StringTokenizer
//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//StringTokenizer st = new StringTokenizer(br.readLine());
//int N = Integer.parseInt(st.nextToken());
