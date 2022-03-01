package Algo_2022.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10709_기상캐스터_KCY {
	static int H,W;
	static int[][] arr;
	static char[][]map;
	static boolean[][]v;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		map = new char[H][W];
		v = new boolean[H][W];
		for(int i=0; i<H;i++) {
			String str = br.readLine();
			for(int j=0;j<W;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		// 맨 처음 -1로 초기화
		for(int i=0; i<H;i++) {
			for(int j=0;j<W;j++) {
				arr[i][j] = -1;
			}
		}
		// for문은 W만큼 돈다
		for(int w=0; w<W; w++) {
			
			for(int i=0; i<H;i++) {
				for(int j=0;j<W;j++) {
					// if c면 이동한만큼 표시
					if(map[i][j]=='c' && !v[i][j]) {
						arr[i][j] = w;
						v[i][j] = true;
					}
				}
			}
			// 구름 이동
			move();
		}
		// 출력
		for(int i=0; i<H;i++) {
			for(int j=0;j<W;j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}
	}
	private static void move() {
		for(int i=0; i<H;i++) {
			for(int j=W-1; j>=0; j--) {
				if(j>0) {
					map[i][j]=map[i][j-1];
				}else {
					map[i][j]='.';
				}
					
			}
		}
	}

}
