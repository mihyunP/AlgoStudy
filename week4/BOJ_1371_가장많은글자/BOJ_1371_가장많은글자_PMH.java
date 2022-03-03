package week4_구현;

import java.util.Scanner;

public class BOJ_1371_가장많은글자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int['z' - 'a' + 1]; // 알파벳 : 26개, 숫자 배열 선언시 0으로 초기화됨.
//		Arrays.fill(cnt, 0);

		while (sc.hasNextLine()) {
			String str = sc.nextLine();
//			System.out.println(str);
//			System.out.println(sc.hasNextLine());

			for (int i = 0; i < str.length(); i++) {
//				System.out.println(str.charAt(i));
				if (str.charAt(i) != ' ') {
					cnt[str.charAt(i) - 'a']++;
				}
			}
		}

		int max = 0; // 가장 많은 글자가 나온횟수
		for (int i = 0; i < cnt.length; i++) {
			if (max < cnt[i]) {
				max = cnt[i];
			}
		}

		for (int i = 0; i < cnt.length; i++) {
			if (max == cnt[i]) {
				System.out.print((char) (i + 'a'));
			}
		}
	}

}

// sc.next() : 공백을 구분자로 봄 ,sc.nextLine() : 공백을 문자로 봄, 개행(\n)만 구분자로 봄
// sc.hasNext() : 입력버퍼에 더 가지고 나올게 있는지(있으면:true, 없으면:false)
