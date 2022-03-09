import java.util.Scanner;

public class BOJ_6603_로또 {
	static int k;
	static int[] S;
	static int[] sel;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		while (true) {
			// k입력 
			k = sc.nextInt(); // 원소의 개수 (6 < k < 13)
			if (k==0) {
				break;
			}
			
			// S 입력 
			S = new int[k]; // 
			for (int i = 0; i < S.length; i++) {
				S[i] = sc.nextInt();
			}
			sel = new int[6];
			
			// 모든 조합 출력
			comb(0,0);
			System.out.println(); // 각 테케별로 한줄씩 띄어쓰기 
			
		}// End while
		
	}
	
	private static void comb(int idx, int cnt) {
		// TODO Auto-generated method stub 
		
		
		if (cnt==6) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		if (idx==S.length) {
			return;
		}
		
		
		// 뽑을 때 
		sel[cnt] = S[idx];
//		System.out.println("cnt+1: "+(cnt+1)+" "+"idx+1: "+(idx+1));
		comb(idx+1,cnt+1);
		
		// 안 뽑을 때 
		comb(idx+1,cnt);
		
	}

	

}
