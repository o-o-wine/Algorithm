import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	// static field
	public static char[] password;
	public static String[] list;
	
	// main method
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			Queue<Character> q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int wordlen = N / 4;
			
			Set<String> set = new HashSet<>();
			
			String str = br.readLine();
			for(int i = 0; i < str.length(); i++) {
				q.add(str.charAt(i));
			}
			
			for(int rotate = 0; rotate < wordlen; rotate++) {
				char c = q.poll();
				q.add(c);
				
				for(int i = 0; i < 4; i++) {
					StringBuilder sb = new StringBuilder();
					
					for(int j = 0; j < wordlen; j++) {
						char tmp = q.poll();
						sb.append(tmp);
						q.add(tmp);						
					}
					
					set.add(sb.toString());
				}
			}
			
			int max = 0;
			
			List<String> list = new ArrayList<>(set);
			List<Integer> decimal = new ArrayList<>();
			
			for(int i = 0; i < list.size(); i++) {
				decimal.add(getDecimal(list.get(i)));
			}
			
			Collections.sort(decimal, Collections.reverseOrder());
			
			System.out.println("#" + tc + " " + decimal.get(K - 1));
		}
	}
	
	// HexaDecimal to Decimal
	public static int getDecimal(String hex) {
		String digits = "0123456789ABCDEF";
		
		int val = 0;

		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			int d = digits.indexOf(c);
			
			val = 16 * val + d;
		}
		
		return val;
	}
}
