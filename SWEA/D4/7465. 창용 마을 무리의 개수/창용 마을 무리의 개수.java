import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M, ans;
	static int[] parents;
		    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N + 1];
			
			makeSet();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);			
			}
			
			for(int cnt = 1; cnt <= N; cnt++) {
				if(parents[cnt] == cnt)
					ans ++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void makeSet() {
		for(int i = 0; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int num) {
		if(num == parents[num]) 
			return num;
		return parents[num] = find(parents[num]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
//		if(pa != pb) 
//			parents[pb] = pa;
		
		if(a < b) 
			parents[pb] = pa; 
		else 
			parents[pb] = pa;
		
	}
}

