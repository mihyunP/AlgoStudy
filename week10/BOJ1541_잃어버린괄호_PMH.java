package week10;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1541_잃어버린괄호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); // 양수와 +, -
		ArrayList<Integer>num = new ArrayList<>();
		ArrayList<Character>cal = new ArrayList<>();
		
		String tmp = "";
		
		for (int i = 0; i < str.length(); i++) {
			
			if (str.charAt(i)=='+' || str.charAt(i)=='-') {
//				System.out.println(str.charAt(i));
				cal.add(str.charAt(i));
			}else {
				while (true) {
					if (i==str.length()) {
//						System.out.println(Integer.valueOf(tmp));
						num.add(Integer.valueOf(tmp));
						break;
					}else if (str.charAt(i)=='+'||str.charAt(i)=='-') {
//					System.out.println(Integer.valueOf(tmp));
					num.add(Integer.valueOf(tmp));
						i--;
						tmp="";
						break;
					}
					else {
						tmp += str.charAt(i);
//						System.out.println("tmp : "+tmp);
						i++;
					}
					
				}
				
				
			}
			
		} // 입력 받아서, 숫자 연산기호 나누기
		

		ArrayList<Integer> plus = new ArrayList<Integer>();
		int n = num.get(0);
		int idx = 0;
		// 덧셈 쭉하기
		for (int i = 0; i <cal.size() ; i++) {
			if (cal.get(i)=='+') {
				n += num.get(++idx);
//				System.out.println("idx : "+ idx);
				System.out.println("n+ : "+ n);
			}else {
				plus.add(n);
//				System.out.println("n- : "+ n);
				n=num.get(++idx);
			}
		}
		System.out.println("lastN : "+n);
		plus.add(n);
		
		// 뺄셈 쭉하기
		int ans = plus.get(0);
		for (int i = 1; i <plus.size() ; i++) {
			ans -= plus.get(i);
		}
	
		System.out.println(ans);
	}

}
