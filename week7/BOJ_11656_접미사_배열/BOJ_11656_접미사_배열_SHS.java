import java.util.*;
import java.io.*;

public class Main {

	static String S;
	static String[] ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		S = br.readLine();
		int len = S.length();
		
		ans = new String[len];
		
		for (int i = 0; i < len; i++) {
			ans[i] = S.substring(i, len);
		}
		
		Arrays.sort(ans);
		
		for (int i = 0; i < len; i++) {
			sb.append(ans[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}
