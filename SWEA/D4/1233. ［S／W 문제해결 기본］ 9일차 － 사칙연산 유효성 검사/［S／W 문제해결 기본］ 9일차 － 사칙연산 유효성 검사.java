import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] str = new String[N];
			int result = 1, node_check = N / 2 - 1;
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				str[i] = st.nextToken();
			}
						
			for(int i = 0; i < N; i++) {
				if(str[i].charAt(0) >= '0' && str[i].charAt(0) <= '9') {
					if(i <= node_check) {
						result = 0;
						break;
					}
				}
				else {
					if (i > node_check) {
						result = 0;
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}			
	}
}
