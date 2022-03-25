package week7_정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_1431_시리얼번호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 기타의 개수
		
		String[] serial = new String[N];
		
		for(int i=0;i<N;i++) {
            serial[i]=sc.next();
        }//입력

	     Arrays.sort(serial,new Comparator<String>() {
	            @Override
	            public int compare(String o1, String o2) {
	                if(o1.length()<o2.length()) { // 짧을수록
	                    return -1;
	                }
	                else if(o1.length()==o2.length()) {
	                    if(add(o1)==add(o2)) {
	                        return o1.compareTo(o2); // 사전순
	                        
	                    }
	                    else {
	                        return Integer.compare(add(o1), add(o2)); // 숫자 합이 작을수록
	                    }
	                }
	                else {
	                    return 1;
	                }
	                
	            }
	        });
	     
	        for (int i = 0; i < N; i++) {
	        	System.out.println(serial[i]);
			}
		
	}
	
	public static int add(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
                sum+=s.charAt(i)-'0';
            }
        }
        return sum;
    }

}
