import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N, L, Max_point;
	public static int[] point;
	public static int[] kcal;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Max_point = 0;
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			point = new int[N];
			kcal = new int[N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				point[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0, 0);
			
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(tc).append(' ').append(Max_point);
			
			System.out.println(sb);
		}
	}
	
	public static void combination(int index, int sum_point, int sum_kcal) {
		if(sum_kcal > L) {
			return;
		}
		
		if(index == N) {
			Max_point = Math.max(Max_point, sum_point);
			return;
		}
		
		combination(index + 1, sum_point + point[index], sum_kcal + kcal[index]);
		combination(index + 1, sum_point, sum_kcal);
	}
}
