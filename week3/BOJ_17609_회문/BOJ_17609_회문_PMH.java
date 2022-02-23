package week3_문자열;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 0: 회문
		// 1: 유사회문
		// 2: 그외
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 문자열 개수T (1 ≤ T ≤ 30)
		
		for (int i = 0; i < T; i++) {
			
			// 문자열 입력받기
			String str = sc.next(); 
			int len = str.length(); 
			
			
			
			// 회문인 경우
			StringBuffer sb = new StringBuffer(str); 
			String revString = sb.reverse().toString();
//			System.out.println(str);
//			System.out.println(revString);
			
			if (str.equals(revString)) {
				System.out.println(0);
			}
			// 회문이 아닌경우
			else {
				int start = -1; 
				int end = len; 
				while(true) {
					start+=1; 
					end-=1; 
					
					if (str.charAt(start) != str.charAt(end)) {						
						
						// 반례 : aapqbcbqpqaa ***앞에서 재껴지고, 뒤에서도 재껴지지만 뒤에서 재낄때만 유사회문이 되므로 앞/뒤 두 곳에서 다 재껴보기!***
						// 앞에서 재끼기
						if (str.charAt(start+1)==str.charAt(end)) {
							
							String temp = str.substring(start+1, end+1);							
							sb = new StringBuffer(temp); 
							String revTemp = sb.reverse().toString();
							
//							System.out.println(temp);
//							System.out.println(revTemp);
							
							if (temp.equals(revTemp)) {
								System.out.println(1); // 유사회문
								break;
							}	
						}
						// 뒤에서 재끼기	
						if (str.charAt(start)==str.charAt(end-1)) {
							
							String temp = str.substring(start, end);
							sb = new StringBuffer(temp); 
							String revTemp = sb.reverse().toString();
							
//							System.out.println(temp);
//							System.out.println(revTemp);
							
							if (temp.equals(revTemp)) {
								System.out.println(1); // 유사회문
								break;
							}
						}
						
						System.out.println(2); // 그외
							break;
						}
					}
					
				}

			}
			
			
		}

	}
