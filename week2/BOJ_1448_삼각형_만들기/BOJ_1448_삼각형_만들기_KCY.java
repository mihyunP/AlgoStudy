package Algo_2022.week02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1448_삼각형_만들기_KCY {
	/**
	 * 세 변의 길이가 주어질 때, 한 변의 길이가 다른 두 변의 길이의 합보다 크다면 삼각형이 되지 않습니다. 
	 * 예컨데 아래와 같이 삼각형의 세변 a, b, c에 대하여 a>b+c라면 삼각형을 만들 수가 없습니다
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	// 한 변의 길이가 다른 두 변의 길이의 합보다 크다면 삼각형 X
	// a<b+c 면 삼각형O
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream(("input/삼각형_만들기.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		// 삼각형 만들 수 없으면 -1
		int res=-1;
		
		for(int i=0; i<N-2; i++) {
			// 삼각형이면
			if(arr[i]< arr[i+1] + arr[i+2]) {
				res = Math.max(res, arr[i]+arr[i+1]+arr[i+2]);
			}
		}
		System.out.println(res);
	}

}
