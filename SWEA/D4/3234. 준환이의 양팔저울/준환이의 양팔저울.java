import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int[] weight;
	public static boolean[] visited;
	public static int answer, N, sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sum = 0; answer = 0;
			
			N = Integer.parseInt(br.readLine());
			
			weight = new int[N];
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine()); 
			for(int n = 0; n < N; n++) {
				weight[n] = Integer.parseInt(st.nextToken());
				sum += weight[n];
			}
			
			DFS(0, 0, 0);
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static void DFS(int depth, int left, int right) {
		// 종료 조건
		if(depth == N) {
			answer ++;
			return;
		}
		
		// 가지치기
		// 나는 총합을 알고 있음
		if(left >= sum - left) {
			answer += (Math.pow(2, N - depth) * factorial(N - depth));
			return;
		}
		
		// search
		for(int i = 0; i < N; i++) {
			// 방문했을 경우
			if(visited[i]) { 
				continue;
			}
			
			// 방문했음
			visited[i] = true;
			// 왼쪽에 더해주되
			DFS(depth + 1, left + weight[i], right);	
			// 오른쪽에 현재 선택한 무게추를 더해도 왼쪽보다 작다면 
			if(right + weight[i] <= left) {
				DFS(depth + 1, left, right + weight[i]);
			}
			
			// Backtracking
			visited[i] = false;
		}
	}
	
	public static int factorial(int num) {
        if (num == 1)
            return 1;
        else
            return num * factorial(num - 1);
 
    }
}
