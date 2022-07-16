package week10;

import java.util.Scanner;
import java.util.Stack;

public class BOJ4949_균형잡힌세상 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String str = (String) sc.nextLine();

			if (str.equals(".")) {
				break; // return
			} // 입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.
			
			Stack stack = new Stack<Character>();
			int len = str.length();
//			System.out.println("len : "+len);

			for (int i = 0; i < len; i++) {

//				System.out.println("stacksize : "+stack.size());
				if (str.charAt(i) == '(' || str.charAt(i) == '[') { // 여는 괄호 스택에 넣기
					stack.push(str.charAt(i));
				} else if (str.charAt(i) == ')') { // 닫는 괄호 스택에서 빼기
					if (stack.size() == 0) {
						System.out.println("no");
						break;
					}
					char c = (char) stack.pop();
					if (c != '(') {
						System.out.println("no");
						break;
					}
				} else if (str.charAt(i) == ']') { // 닫는 괄호 스택에서 빼기
					if (stack.size() == 0) {
						System.out.println("no");
						break;
					}
					char c = (char) stack.pop();
					if (c != '[') {
						System.out.println("no");
						break;
					}
				}

				if (i == len - 1) {
//					System.out.println(i);
					if (stack.isEmpty()) { // cf. stack.size()==0
						System.out.println("yes");
					} else {
						System.out.println("no");
					} // 반례 : (

				}

			}

		}

	}
	
}
