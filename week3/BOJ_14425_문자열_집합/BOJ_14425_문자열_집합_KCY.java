package Algo_2022.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14425_문자열_집합_KCY {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		int cnt=0;
		
		for(int i=0; i<N; i++) {
			hs.add(br.readLine());
		}
		for(int i=0; i<M; i++) {
			if(hs.contains(br.readLine())) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
