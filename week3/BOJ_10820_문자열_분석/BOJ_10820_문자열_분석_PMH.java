import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) { // 다음이 있을때까지 반복
			int[] arr = new int[4]; // 소문자, 대문자, 숫자, 공백의 개수
			String str = sc.nextLine(); // 공백문자 포함 한줄씩 받아오기
			
			for (int j = 0; j < str.length(); j++) {
				
				if (str.charAt(j)==' ') { // 아스키 코드값 : 32
					arr[3]++;
				}else if (str.charAt(j)>='A' && str.charAt(j)<='Z') { // 아스키 코드값 : 65~90
					arr[1]++;
				}else if (str.charAt(j)>='a' && str.charAt(j)<='z') { // 아스키 코드값 : 97~122
					arr[0]++;
				}else if (str.charAt(j)>='0' && str.charAt(j)<='9') { // 아스키 코드값 : 48~57
					arr[2]++;
				}
			}
			
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
			
		}
			
		
	}
