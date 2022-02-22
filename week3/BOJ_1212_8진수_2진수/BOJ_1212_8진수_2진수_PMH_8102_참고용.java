package week3_문자열;

import java.util.ArrayList;
import java.util.Scanner;

public class 팔진수이진수 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 8진수 -> 10진수 -> 2진수
		Scanner sc = new Scanner(System.in);
		String octal = sc.next(); 
		long num = 0;
		
		for (int i = octal.length()-1; i >= 0; i--) {
			num += (octal.charAt(i)-'0')*Math.pow(8, octal.length()-1-i); // -'0' : 문자'1' -> 숫자1로
		}
		
//		System.out.println(num);
		
		if (num==0) {
			System.out.println(0);
			return;
		} 
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while (num>0) {
			
			list.add((int)num%2);
			
			num/=2;			
		}
				
			for (int i = list.size()-1; i >= 0; i--) {
				System.out.print(list.get(i));
			}	
	}
}
