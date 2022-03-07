package Algo_2022.week05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11729_하노이_탑_이동_순서_KCY {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write((int)Math.pow(2, n)-1+"\n");
		hanoi(n,1,2,3,bw);
		bw.flush();  
		bw.close();
	}

	private static void hanoi(int n, int start, int temp, int to, BufferedWriter bw) throws IOException {
		if(n<1) return;
		//start->temp
		// 맨 아래 제외한 원반을 temp로 재귀적으로 이동시킴
		hanoi(n-1,start,to,temp,bw);
		// 맨 아래 원반을 목적지로 이동
		//bw.write(n+"번째 원반을 "+start+"에서 "+to+"로 옮김\n");
		bw.write(start+" "+to+"\n");
		//temp->to
		// temp로 옮겼던 기둥들을 목적지 기둥으로 재귀적으로 이동시킴
		hanoi(n-1,temp,start,to,bw);
	}

}
