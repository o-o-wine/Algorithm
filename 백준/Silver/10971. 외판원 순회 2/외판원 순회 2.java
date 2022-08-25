import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, min = Integer.MAX_VALUE;
	public static int[][] map;
	public static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int row = 0; row < N; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0; col < N; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N];
		visited[0] = true;
		DFS(0, 0);
		
		System.out.println(min);
	}
	
	static void DFS(int cur, int cost) {
		if(visitCheck()) {
			if (map[cur][0] != 0) {
				min = Math.min(min, cost + map[cur][0]);
			}
			return;
		}
		
		for(int i = 0; i < N; i++){
            if (!visited[i] && map[cur][i] != 0) {
                visited[i] = true;
                DFS(i, cost + map[cur][i]);
                visited[i] = false;
            }
        }
	}
	
	static boolean visitCheck() {
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		
		return true;
	}
}

