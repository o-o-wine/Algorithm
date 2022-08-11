import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static String str;
	static char[] tmp = new char[50];
	
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T, test_case;
		
        T = sc.nextInt();
        sc.nextLine();
		
		for (test_case = 1; test_case <= T; test_case++) {
			char cur = '\0';
			int cnt = 0;
			
			str = sc.nextLine();

			Arrays.fill(tmp, '\0');
			
			if (str.charAt(0) == '1') {
				cnt++;
				cur = str.charAt(0);
			}
			else if (str.charAt(0) == '0') {
				cur = str.charAt(0);
			}

			bit_mask(cur, 0);

			for (int i = 1; i < str.length(); i++) {
				if (cur != str.charAt(i)) {
					//cout << cur << " " << str[i] << " 진입" << '\n';
					cur = str.charAt(i);
					cnt++;
					bit_mask(cur, i);
				}
			}
			
			System.out.println("#" + test_case + " " +cnt);
		}
	}
	
	static void bit_mask(char cur, int n) {
		for (int i = n; i < str.length(); i++) {
			tmp[i] = cur;
		}
	}
}
